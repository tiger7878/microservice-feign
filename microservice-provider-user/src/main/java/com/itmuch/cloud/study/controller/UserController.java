package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        User user = userRepository.findOne(id);

        logger.info("provider user findById : " + id);

        return user;
    }

    @GetMapping("/get")
    public User get(User user){
        return user;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }
}
