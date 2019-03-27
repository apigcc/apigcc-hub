package com.apigcc.hub.service;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.domain.Staff;
import com.apigcc.hub.repository.StaffRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StaffService {

    @Resource
    StaffRepository staffRepository;

    /**
     * 获取用户相关的namespace
     * @param userid
     * @return
     */
    @GetMapping("/users/{userid}/namespaces")
    public Response<List<Staff>> getByUserid(@PathVariable int userid){
        List<Staff> staffs = staffRepository.findByUserid(userid);
        return Response.success(staffs);
    }

    /**
     * 获取namespace下的所有用户
     * @param id
     * @return
     */
    @GetMapping("/namespaces/{id}/staffs")
    public Response<List<Staff>> getByNamespace(@PathVariable String id){
        List<Staff> staffs = staffRepository.findByNamespaceid(id);
        return Response.success(staffs);
    }

    /**
     * namespace下添加用户
     * @param id
     * @param userid
     * @return
     */
    @PostMapping("/namespaces/{id}/staffs")
    public Response create(@PathVariable String id, int userid){
        Staff staff = new Staff();
        staff.setNamespaceid(id);
        staff.setUserid(userid);
        staffRepository.save(staff);
        return Response.success();
    }

    /**
     * namespace下移除用户
     * @param id
     * @param userid
     * @return
     */
    @DeleteMapping("/namespaces/{id}/staffs/{userid}")
    public Response delete(@PathVariable String id, @PathVariable int userid){
        Staff staff = new Staff();
        staff.setNamespaceid(id);
        staff.setUserid(userid);
        staffRepository.delete(staff);
        return Response.success();
    }



}
