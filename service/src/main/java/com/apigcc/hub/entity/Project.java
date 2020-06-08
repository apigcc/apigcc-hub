package com.apigcc.hub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
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
    String git;
    /**
     * 分支
     */
    String branch;
    /**
     * 源码用户名
     */
    String username;
    /**
     * 源码密码
     */
    @JsonIgnore
    String password;
    /**
     * 状态
     */
    Status status;
    /**
     * 项目创建时间
     */
    @Column(updatable = false)
    Date createTime;
    /**
     * 最后构建时间
     */
    Date buildTime;
    /**
     * 代码提交id，文档基于哪次提交构建
     */
    String gitCommitId;
    /**
     * 代码提交信息
     */
    String gitCommitMessage;
    /**
     * 构建过程中的错误信息提示
     */
    String msg;

    /**
     * 项目目录
     */
    String projectDir;

    /**
     * 项目构建触发链接
     */
    String buildUrl;

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}
