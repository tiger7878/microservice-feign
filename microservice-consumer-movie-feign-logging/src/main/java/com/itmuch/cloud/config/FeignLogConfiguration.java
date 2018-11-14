package com.itmuch.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign日志配置类
 * User: monkey
 * Date: 2018-11-14 10:08
 */
@Configuration
public class FeignLogConfiguration {

    /**
     * 日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
//        return Logger.Level.NONE;//不做任何记录
//        return Logger.Level.BASIC;//仅记录请求方法、URL、响应状态码以及执行时间
//        return Logger.Level.HEADERS;//在记录BASIC的基础上，记录请求和响应的header
        return Logger.Level.FULL;//请求和响应的header，body和元数据
    }

}
