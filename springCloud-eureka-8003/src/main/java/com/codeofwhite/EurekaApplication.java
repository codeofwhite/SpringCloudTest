package com.codeofwhite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author codeofwhite
 * @date 2024/5/14
 * @Description
 */
@SpringBootApplication
// 表示这个服务可以接受别人注册
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class , args);
    }
}
