package com.apigcc.hub.repository;

import com.apigcc.hub.entity.Project;
import com.apigcc.hub.entity.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Repository
public interface ProjectRepository extends CrudRepository<Project,String> {

    @Transactional(propagation = REQUIRES_NEW)
    @Modifying
    @Query("update Project set status=?2,msg=?3 where id=?1")
    void updateStatus(String id, Status building, String msg);

    @Transactional
    @Modifying
    @Query("update Project set buildTime=?2 where id=?1")
    void updateBuildTime(String id, Date buildTime);

    @Transactional
    @Modifying
    @Query("update Project set gitCommitId=?2,gitCommitMessage=?3 where id=?1")
    void updateGitLog(String id, String commitId, String msg);
}
