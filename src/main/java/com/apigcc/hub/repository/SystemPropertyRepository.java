package com.apigcc.hub.repository;

import com.apigcc.hub.entity.SystemProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPropertyRepository extends JpaRepository<SystemProperty,String> {
}
