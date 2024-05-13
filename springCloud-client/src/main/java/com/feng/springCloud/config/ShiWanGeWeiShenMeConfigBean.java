package com.feng.springCloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 拾万个为什么
 * @date 2021/2/28
 * @since JDK1.8
 */
@Configuration
public class ShiWanGeWeiShenMeConfigBean {

    //配置config，用于发现服务

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}