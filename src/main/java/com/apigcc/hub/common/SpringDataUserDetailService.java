package com.apigcc.hub.common;

import com.apigcc.hub.domain.User;
import com.apigcc.hub.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;

@Component
public class SpringDataUserDetailService implements UserDetailsService {

    @Resource
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optUser = userRepository.findByUsername(username);
        if(optUser.isPresent()){
            User user = optUser.get();
            return org.springframework.security.core.userdetails.
                    User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .authorities(Collections.emptyList())
                        .build();
        }

        throw new UsernameNotFoundException("username:"+username+" not found");
    }
}
