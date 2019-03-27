package com.apigcc.hub.service;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.dto.UserCreateDTO;
import com.apigcc.hub.dto.UserDTO;
import com.apigcc.hub.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
public class UserService {

    @Resource
    UserRepository userRepository;

    @PostMapping
    @Transactional
    public Response post(UserCreateDTO userDTO){
        userRepository.save(userDTO.toUser());
        return Response.success();
    }

    @PutMapping
    @Transactional
    public Response put(UserDTO userDTO){
        userRepository.save(userDTO.toUser());
        return Response.success();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Response delete(int id){
        userRepository.deleteById(id);
        return Response.success();
    }

}
