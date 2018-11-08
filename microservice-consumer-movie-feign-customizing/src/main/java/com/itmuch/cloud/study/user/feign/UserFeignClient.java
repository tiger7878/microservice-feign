package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.config.FeignConfiguration;
import com.itmuch.cloud.study.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign接口
 * 使用@FeignClient的configuration属性指定Feign的配置类
 * User: Administrator
 * Date: 2018-11-08 14:50
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class) //用于创建Ribbon负载均衡器
public interface UserFeignClient {

    /**
     * 使用Feign的注解@RequestLine
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);

}
