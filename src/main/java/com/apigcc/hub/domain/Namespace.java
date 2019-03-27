package com.apigcc.hub.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Namespace {

    @Id
    String id;
    String name;
    @Column(updatable = false)
    int projects;
    @Column(updatable = false)
    Date createTime;

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }
}
