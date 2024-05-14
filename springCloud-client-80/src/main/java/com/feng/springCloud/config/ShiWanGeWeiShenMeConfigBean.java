package com.feng.springCloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author codeofwhite
 * @date 2024/5/14
 */
@Configuration
public class ShiWanGeWeiShenMeConfigBean {

    // 配置config，用于发现服务
    // 配置负载均衡
    @Bean //将 RestTemplate 注入到容器中
    @LoadBalanced //在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}