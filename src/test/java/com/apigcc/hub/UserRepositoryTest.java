package com.apigcc.hub;

import ch.qos.logback.core.db.dialect.SQLiteDialect;
import com.apigcc.hub.domain.User;
import com.apigcc.hub.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Resource
    UserRepository userRepository;

    @Test
    public void testSave(){

        User user = new User();

        user.setUsername("wangzhe");
        user.setPassword("wangzhe");
        user.setName("王哲");
        userRepository.save(user);
    }

    @Test
    public void testQuery(){

        userRepository.findAll().forEach(System.out::println);

    }

}
