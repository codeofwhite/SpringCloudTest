package com.feng.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider.class , args);
    }
}