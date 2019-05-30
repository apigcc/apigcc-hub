package com.apigcc.hub.web;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.dto.BookDTO;
import com.apigcc.hub.dto.ProjectDTO;
import com.apigcc.hub.entity.Project;
import com.apigcc.hub.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Resource
    ProjectService projectService;

    /**
     * 获取所有项目名及文档组信息
     * @return
     */
    @GetMapping("/books")
    public Response<List<BookDTO>> menu(){
        return Response.success(projectService.menu());
    }

    /**
     * 获取所有项目信息
     * @return
     */
    @GetMapping
    public Response<Iterable<Project>> list(){
        return Response.success(projectService.list());
    }

    /**
     * 获取单个项目信息
     * @return
     */
    @GetMapping("/{id}")
    public Response<Project> get(@PathVariable String id){
        return Response.success(projectService.get(id));
    }

    /**
     * 保存项目信息
     */
    @PostMapping
    public Response create(@RequestBody ProjectDTO dto){
        projectService.create(dto);
        return Response.success();
    }

    /**
     * 移除项目，同时移除工作空间
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable String id){
        projectService.delete(id);
        return Response.success();
    }

    /**
     * 触发构建
     */
    @RequestMapping("/{id}/build")
    public Response build(@PathVariable String id){
        projectService.build(id);
        return Response.success();
    }

}
