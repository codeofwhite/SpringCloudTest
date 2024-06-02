package codeofwhite.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author codeofwhite
 * @date 2024/6/1
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient //开启 Eureka 客户端功能
@EnableCircuitBreaker //激活熔断器功能
public class SpringCloudProviderHystrix8004Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrix8004Application.class, args);
    }

}
