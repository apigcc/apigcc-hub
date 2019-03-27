package com.apigcc.hub.dto;

import com.apigcc.hub.domain.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {

    String id;
    String namespace;
    String name;
    String git;
    String gitUsername;
    String gitPassword;

    public Project toProject(){
        Project project = new Project();
        project.setKey(new Project.Key(id,namespace));
        project.setName(name);
        project.setGit(git);
        project.setGitUsername(gitUsername);
        project.setGitPassword(gitPassword);
        return project;
    }

}
