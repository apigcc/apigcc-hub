package com.apigcc.hub.repository;

import com.apigcc.hub.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Integer> {

    List<Staff> findByUserid(Integer userid);

    List<Staff> findByNamespaceid(String id);
}
