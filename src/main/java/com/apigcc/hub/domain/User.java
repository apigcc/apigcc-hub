package com.apigcc.hub.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@ToString
public class User {

    @Id @GeneratedValue
    int id;
    @Column(unique = true)
    String username;
    String password;
    String name;
    @Column(updatable = false)
    Date createTime;

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}
