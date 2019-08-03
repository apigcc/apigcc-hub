package com.apigcc.hub.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String projectId;

    String name;
}
