package com.apigcc.hub.dto;

import com.apigcc.hub.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Setter
@Getter
public class UserDTO {

    int id;
    String username;
    String name;
    Date createTime;

    public User toUser(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }

}
