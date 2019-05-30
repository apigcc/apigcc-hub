package com.apigcc.hub;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static org.eclipse.jgit.lib.Constants.R_HEADS;

public class GitTest {

    String buildDir = "out";
    String id = "ubisor-backend";
    String gitUrl = "https://gitee.com/ubisor-dev/ubisor-backend";
    String branch = "master";
    String username = "";
    String password = "";

    @Test
    public void testSync(){

        Path projectDir = Paths.get(buildDir,id).toAbsolutePath();

        Git git = null;
        try{

            if(Files.notExists(projectDir)){
                CloneCommand cloneCommand = Git.cloneRepository();
                cloneCommand.setBranch(branch);
                cloneCommand.setURI(gitUrl).setDirectory(projectDir.toFile());
                if(StringUtils.hasText(username) && StringUtils.hasText(password)){
                    cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username,password));
                }
                git = cloneCommand.call();
            }else{
                git = Git.open(projectDir.toFile());
                boolean branchExists = false;
                String refName = R_HEADS + branch;
                for (Ref ref : git.branchList().call()) {
                    if(Objects.equals(ref.getName(),refName)){
                        branchExists = true;
                    }
                }

                CheckoutCommand checkoutCommand = git.checkout();
                checkoutCommand.setName(branch);
                if(!branchExists){
                    checkoutCommand.setCreateBranch(true);
                }
                checkoutCommand.call();
                PullCommand pullCommand = git.pull();
                if(StringUtils.hasText(username) && StringUtils.hasText(password)){
                    pullCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username,password));
                }
                pullCommand.setStrategy(MergeStrategy.THEIRS);
                pullCommand.call();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(git!=null){
                git.close();
            }
        }

    }

    @Test
    public void testClone() throws GitAPIException {
        Git.cloneRepository()
                .setCloneAllBranches(true)
                .setURI("https://gitee.com/ubisor-dev/ubisor-backend")
                .setDirectory(new File("out/ubisor-backend"))
                .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username,password))
                .call().close();
    }



    @Test
    public void testCheckout() throws IOException, GitAPIException {

        Path out = Paths.get("out", "ubisor-backend").toAbsolutePath();

        String branchName = "bak";

        Git git = Git.open(out.toFile());
        List<Ref> call = git.branchList().call();
        System.out.println(call);
        boolean branchExists = false;
        String refName = R_HEADS + branchName;
        for (Ref ref : call) {
            if(Objects.equals(ref.getName(),refName)){
                branchExists = true;
            }
        }

        if(!branchExists){
            Files.deleteIfExists(out);
        }

        CheckoutCommand checkout = git.checkout();
        checkout.setName(branchName);
        if(!branchExists){
            checkout.setCreateBranch(true);
        }
        checkout.call();
        git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider(username,password)).call();
        git.close();
    }


    @Test
    public void testLog() throws IOException, GitAPIException {
        Iterable<RevCommit> call = Git.open(new File("out/ubisor-backend"))
                .log().setMaxCount(1).call();
        call.forEach(revCommit -> {
            System.out.println(revCommit.getFullMessage());
            System.out.println(revCommit);
        });
    }

    @Test
    public void testPull() throws IOException, GitAPIException {
        Git.open(new File("out/ubisor-backend"))
                .pull()
                .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username,password))
                .call();
    }

    @Test
    public void testPath(){
        Path build1 = Paths.get("build/").toAbsolutePath();
        String str = build1.toString();
        if (!build1.endsWith(File.separator)) {
            str += File.separator;
        }
        System.out.println(str);
    }

    @Test
    public void testIp() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hostAddress);
    }

}
