package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //申明是Eureka Client
@EnableFeignClients //启用Feign
public class ConsumerMovieMultipleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieMultipleApplication.class, args);
    }
}
