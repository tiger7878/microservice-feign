package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;
import com.itmuch.cloud.study.security.SecurityUser;
import com.itmuch.cloud.study.security.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.Collection;

/**
 * User: monkey
 * Date: 2018-11-06 11:15
 */
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    //GetMapping 是spring4.3提供的注解
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            UserDetails userDetails= (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection=userDetails.getAuthorities();
            for (GrantedAuthority grantedAuthority : collection) {
                logger.info("当前用户是：{}，角色：{}，用户id：{}",
                        userDetails.getUsername(),
                        grantedAuthority.getAuthority(),
                        ((SecurityUser)userDetails).getId());
            }
        }

        User user = userRepository.findOne(id);

        logger.info("provider user findById : " + id);

        return user;
    }
}
