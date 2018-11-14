package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Feign接口
 * User: Administrator
 * Date: 2018-11-08 14:50
 */
@FeignClient(name = "microservice-provider-user") //用于创建Ribbon负载均衡器
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //注意：在使用Feign时PathVariable必须要传参，否则报错
//    @GetMapping("/{id}")，使用Fign时，不能用这种简写方式
    public User findById(@PathVariable("id") Long id);

    //该请求不会成功
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get0(User user);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    User get2(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    User post(@RequestBody User user);
}
