package com.feng.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 拾万个为什么
 * @date 2021/2/28
 * @since JDK1.8
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置
public class DeptClient {

    public static void main(String[] args) {
        SpringApplication.run(DeptClient.class , args);
    }
}