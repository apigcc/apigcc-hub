package com.apigcc.hub.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
public class Project {

    @EmbeddedId
    Key key;
    String name;
    String git;
    String gitUsername;
    String gitPassword;
    @Column(updatable = false)
    Date createTime;

    @PrePersist
    public void prePersist(){
        createTime = new Date();
    }

    @Setter
    @Getter
    @EqualsAndHashCode
    @Embeddable
    public static class Key implements Serializable {
        String id;
        String namespace;

        public Key() {
        }

        public Key(String id, String namespace) {
            this.id = id;
            this.namespace = namespace;
        }
    }

}
