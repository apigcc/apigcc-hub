package com.apigcc.hub.service;

import com.github.apigcc.core.Apigcc;
import com.github.apigcc.core.Context;
import com.github.apigcc.core.common.helper.StringHelper;
import com.apigcc.hub.common.BeanHelper;
import com.apigcc.hub.dto.BookDTO;
import com.apigcc.hub.dto.GitLogDTO;
import com.apigcc.hub.dto.ProjectDTO;
import com.apigcc.hub.entity.BookGroup;
import com.apigcc.hub.entity.Project;
import com.apigcc.hub.entity.Status;
import com.apigcc.hub.repository.BookGroupRepository;
import com.apigcc.hub.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@Service
public class ProjectService {

    @Resource
    ProjectRepository projectRepository;

    @Resource
    BookGroupRepository bookGroupRepository;

    @Resource
    SystemPropertyService systemProperty;

    @Resource
    GitService gitService;

    @Resource
    ProjectService projectService;

    /**
     * 获取所有项目名及文档组信息
     * @return
     */
    public List<BookDTO> menu(){
        Iterable<Project> list = projectRepository.findAll();
        List<BookDTO> result = new ArrayList<>();
        Iterator<Project> iterator = list.iterator();
        while(iterator.hasNext()){
            Project project = iterator.next();
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(project.getId());
            bookDTO.setTitle(project.getTitle());

            BookGroup example = new BookGroup();
            example.setProjectId(project.getId());
            List<BookGroup> bookGroups = bookGroupRepository.findAll(Example.of(example));
            bookDTO.setGroups(bookGroups);

            result.add(bookDTO);
        }
        return result;
    }

    /**
     * 获取所有项目信息
     * @return
     */
    public Iterable<Project> list(){
        return projectRepository.findAll();
    }

    /**
     * 获取单个项目信息
     * @return
     */
    public Project get(String id){
        Optional<Project> project = projectRepository.findById(id);
        if(!project.isPresent()){
            throw new IllegalArgumentException("project not exists");
        }
        return project.get();
    }

    /**
     * 保存项目信息
     */
    @Transactional
    public void create(ProjectDTO dto){
        Project project = new Project();
        if(dto.getId()!=null){
            Optional<Project> optional = projectRepository.findById(dto.getId());
            if(optional.isPresent()){
                project = optional.get();
            }
        }
        BeanHelper.merge(dto,project);
        if(project.getStatus() == null){
            project.setStatus(Status.INIT);
        }

        Path projectPath = Paths.get(systemProperty.getSources(), project.getId()).toAbsolutePath();
        project.setProjectDir(projectPath.toString());
        project.setBuildUrl(systemProperty.getHost()+"/api/projects/"+project.getId()+"/build");
        if(Objects.isNull(project.getSource())){
            project.setSource("");
        }
        if(Objects.isNull(project.getDependency())){
            project.setDependency("");
        }
        if(StringHelper.isBlank(project.getBranch())){
            project.setBranch("master");
        }

        projectRepository.save(project);
    }

    /**
     * 移除项目，同时移除工作空间
     * @param id
     * @return
     */
    @Transactional
    public void delete(String id){
        Project project = get(id);

        projectRepository.deleteById(id);

        //Git remove; build remove
        try {
            FileSystemUtils.deleteRecursively(Paths.get(project.getProjectDir()));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        try {
            FileSystemUtils.deleteRecursively(Paths.get(systemProperty.getBuild(),project.getId()));
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 触发构建
     */
    public void build(String id){
        Project project = get(id);

        try{
            projectRepository.updateBuildTime(project.getId(),new Date());
            projectRepository.updateStatus(project.getId(),Status.BUILDING,"");

            //sync source code
            log.info("sync code from:{}",project.getGit());
            GitLogDTO gitLogDTO = gitService.sync(project);
            projectRepository.updateGitLog(project.getId(),gitLogDTO.getCommitId(),gitLogDTO.getMsg());

            Path projectFolder = Paths.get(systemProperty.getSources(), project.getId());
            log.info("build doc from:{}",projectFolder);

            //build api doc
            Context context = new Context();
            context.setId(project.getId());
            context.setName(project.getTitle());
            context.setDescription(project.getDescription());
            for (String path : project.getSource().split(",")) {
                context.addSource(projectFolder.resolve(path));
            }
            for (String path : project.getDependency().split(",")) {
                if(path.endsWith("jar")){
                    context.addJar(projectFolder.resolve(path));
                }else{
                    context.addDependency(projectFolder.resolve(path));
                }
            }
            context.setBuildPath(Paths.get(systemProperty.getBuild()));
            context.setCss(systemProperty.getStyle());
            Apigcc apigcc = new Apigcc(context);

            com.github.apigcc.core.schema.Project p = apigcc.parse();
            projectService.updateBooks(id, p.getBooks().keySet());

            apigcc.render();

            projectRepository.updateStatus(project.getId(),Status.SUCCESS,"");
        }catch (Exception e){
            log.error("sync code error",e);
            projectRepository.updateStatus(project.getId(),Status.FAIL,e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Transactional
    public void updateBooks(String id, Set<String> books){
        bookGroupRepository.deleteByProjectId(id);

        for (String book : books) {
            BookGroup value = new BookGroup();
            value.setProjectId(id);
            value.setName(book);
            bookGroupRepository.save(value);
        }

    }

    public boolean exists(String id) {
        return projectRepository.existsById(id);
    }
}
