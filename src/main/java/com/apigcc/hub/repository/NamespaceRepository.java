package com.apigcc.hub.repository;

import com.apigcc.hub.domain.Namespace;
import com.apigcc.hub.domain.Staff;
import com.apigcc.hub.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NamespaceRepository extends CrudRepository<Namespace,String> {

    @Modifying
    @Query("update namespace set projects=projects+1 where id=?0")
    int updateProjectsIncrement(String id);
}
