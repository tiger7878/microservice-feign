package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //申明是Eureka Client
@EnableFeignClients //启用Feign
public class ConsumerMovieFeignCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieFeignCustomizingApplication.class, args);
    }
}
