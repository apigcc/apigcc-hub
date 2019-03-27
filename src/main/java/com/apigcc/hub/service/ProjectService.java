package com.apigcc.hub.service;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.domain.Project;
import com.apigcc.hub.dto.ProjectDTO;
import com.apigcc.hub.repository.ProjectRepository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
public class ProjectService {

    @Resource
    ProjectRepository projectRepository;

    /**
     * 获取namespace下的所有项目信息
     * @param namespace
     * @return
     */
    @GetMapping("/namespaces/{namespace}/projects")
    public Response list(@PathVariable String namespace){
        List<Project> list = projectRepository.findByKeyNamespace(namespace);
        return Response.success(list);
    }

    /**
     * 创建项目
     */
    @RequestMapping(value = "/namespaces/{namespace}/projects",
            method = {RequestMethod.POST,RequestMethod.PUT})
    public Response create(@PathVariable String namespace, ProjectDTO dto){
        Assert.isTrue(Objects.equals(dto.getNamespace(),namespace),"namespace错误");
        projectRepository.save(dto.toProject());
        return Response.success();
    }

    /**
     * 移除项目，同时移除工作空间
     * @param namespace
     * @param id
     * @return
     */
    @DeleteMapping("/namespaces/{namespace}/projects/{id}")
    public Response delete(@PathVariable String namespace, @PathVariable String id){
        projectRepository.deleteById(new Project.Key(id,namespace));
        return Response.success();
    }

    /**
     * 触发构建
     */
    @RequestMapping("/namespaces/{namespace}/projects/{id}/build")
    public Response build(){
        return Response.success();
    }

    /**
     * 获取构建的文档，并返回
     */
    @GetMapping("/namespaces/{namespace}/projects/{id}")
    public Response doc(){
        return Response.success();
    }



}
