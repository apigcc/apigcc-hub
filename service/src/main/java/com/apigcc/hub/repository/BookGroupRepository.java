package com.apigcc.hub.repository;

import com.apigcc.hub.entity.BookGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGroupRepository extends JpaRepository<BookGroup,Integer> {

    @Modifying
    void deleteByProjectId(String projectId);
}
