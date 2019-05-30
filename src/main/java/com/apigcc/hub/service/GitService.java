package com.apigcc.hub.service;

import com.apigcc.hub.dto.GitLogDTO;
import com.apigcc.hub.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.eclipse.jgit.lib.Constants.R_HEADS;

@Slf4j
@Service
public class GitService {

    @Resource
    SystemPropertyService systemPropertyService;

    public GitLogDTO sync(Project project){
        Path projectDir = Paths.get(systemPropertyService.getSources(),project.getId()).toAbsolutePath();

        Git git = null;
        try{

            if(Files.notExists(projectDir)){
                CloneCommand cloneCommand = Git.cloneRepository();
                cloneCommand.setBranch(project.getBranch());
                cloneCommand.setURI(project.getGit()).setDirectory(projectDir.toFile());
                if(StringUtils.hasText(project.getUsername()) && StringUtils.hasText(project.getPassword())){
                    cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(project.getUsername(),project.getPassword()));
                }
                git = cloneCommand.call();
            }else{
                git = Git.open(projectDir.toFile());
                boolean branchExists = false;
                String refName = R_HEADS + project.getBranch();
                for (Ref ref : git.branchList().call()) {
                    if(Objects.equals(ref.getName(),refName)){
                        branchExists = true;
                    }
                }

                CheckoutCommand checkoutCommand = git.checkout();
                checkoutCommand.setName(project.getBranch());
                if(!branchExists){
                    checkoutCommand.setCreateBranch(true);
                }
                checkoutCommand.call();
                PullCommand pullCommand = git.pull();
                if(StringUtils.hasText(project.getUsername()) && StringUtils.hasText(project.getPassword())){
                    pullCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(project.getUsername(),project.getPassword()));
                }
                pullCommand.setStrategy(MergeStrategy.THEIRS);
                pullCommand.call();
            }

            GitLogDTO gitDTO = new GitLogDTO();

            Iterable<RevCommit> call = git.log().setMaxCount(1).call();
            call.forEach(revCommit -> {
                gitDTO.setCommitId(revCommit.getName());
                gitDTO.setMsg(revCommit.getFullMessage());
            });

            return gitDTO;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new IllegalArgumentException(e);
        }finally {
            if(git!=null){
                git.close();
            }
        }
    }

}
