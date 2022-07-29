package com.fortress.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fortress.demo.mapper.UserMapper;
import com.fortress.demo.vo.UserVO;

@Service
public class LoginIDPWDValidator implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String insertedID) throws UsernameNotFoundException {
        UserVO user = userMapper.getUser(insertedID);

        if (user == null) {
            return null;
        }

        String pw = user.getUserPwd();
        String roles = null;

        if (user.getUserLevel() != 0 && user.getUserLevel() < 5) {
            roles = "ADMIN";
        } else {
            roles = "MEMBER";
        }

        return User.builder()
                    .username(insertedID)
                    .password(pw)
                    .roles(roles)
                    .build();
    }
}
