package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * User: monkey
 * Date: 2018-11-06 11:44
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    //该请求不会成功
    //测试URL：http://localhost:8010/user/get0?id=1&username=张三
    @RequestMapping(value = "/user/get0", method = RequestMethod.GET)
    public User get0(User user) {
        return this.userFeignClient.get0(user);
    }

    //测试URL：http://localhost:8010/user/get1?id=1&username=张三
    @RequestMapping(value = "/user/get1", method = RequestMethod.GET)
    public User get1(User user) {
        return this.userFeignClient.get1(user.getId(), user.getUsername());
    }

    //测试URL：http://localhost:8010/user/get2?id=1&username=张三
    @RequestMapping(value = "/user/get2", method = RequestMethod.GET)
    public User get2(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        return this.userFeignClient.get2(map);
    }

    //测试URL:http://localhost:8010/user/post
    //{"id":1,"username":"张三"}
    @RequestMapping(value = "/user/post", method = RequestMethod.POST)
    public User post(@RequestBody User user) {
        return this.userFeignClient.post(user);
    }

}
