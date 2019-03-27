package com.apigcc.hub.dto;

import com.apigcc.hub.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class UserCreateDTO {
    
    String username;
    String password;
    String name;

    public User toUser(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }

}
