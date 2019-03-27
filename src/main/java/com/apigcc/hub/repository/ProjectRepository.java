package com.apigcc.hub.repository;

import com.apigcc.hub.domain.Project;
import com.apigcc.hub.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Project.Key> {

    List<Project> findByKeyNamespace(String namespace);

}
