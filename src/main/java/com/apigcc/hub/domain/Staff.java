package com.apigcc.hub.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Staff {

    @Id @GeneratedValue
    int id;
    String namespaceid;
    @OneToOne
    @JoinColumn(name = "namespaceid", referencedColumnName = "id", insertable = false, updatable = false)
    Namespace namespace;
    int userid;
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    User user;
    Date createTime;

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

}
