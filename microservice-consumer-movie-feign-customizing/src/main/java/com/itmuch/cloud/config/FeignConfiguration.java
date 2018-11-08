package com.itmuch.cloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign的配置类
 * 注意：不要在主程序的@ComponetScan中
 * User: monkey
 * Date: 2018-11-08 15:59
 */
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

}
