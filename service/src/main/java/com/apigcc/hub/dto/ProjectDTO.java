package com.apigcc.hub.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProjectDTO {

    @NotBlank
    String id;
    /**
     * 项目名标题
     */
    String title;
    /**
     * 项目描述
     */
    String description;
    /**
     * 项目源码文件夹
     */
    String source;
    /**
     * 依赖项目的源码地址
     */
    String dependency;
    /**
     * 源码地址
     */
    @NotBlank
    String git;

    String branch;

    String username;

    String password;


}
