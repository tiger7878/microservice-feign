package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign接口
 * User: Administrator
 * Date: 2018-11-08 14:50
 */
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    //注意：在使用Feign时PathVariable必须要传参，否则报错
//    @GetMapping("/{id}")，使用Fign时，不能用这种简写方式
    public User findById(@PathVariable("id") Long id);

}
