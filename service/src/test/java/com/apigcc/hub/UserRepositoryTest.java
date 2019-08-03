package com.apigcc.hub;

import com.apigcc.hub.dto.ProjectDTO;
import com.apigcc.hub.web.ProjectController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Ignore
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Resource
    ProjectController projectService;

    @Test
    public void testSave(){

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId("ubcloud");
        projectDTO.setTitle("优碧云");
        projectDTO.setDescription("优碧云接口文档");
        projectDTO.setGit("https://gitee.com/ubisor-dev/ubisor-backend");
        projectDTO.setUsername("");
        projectDTO.setPassword("");
        projectDTO.setSource("ubcloud-front-web");
//        projectDTO.setDependency("");

        projectService.create(projectDTO);

    }

    @Test
    public void testBuild(){
        projectService.build("ubcloud");
    }

}
