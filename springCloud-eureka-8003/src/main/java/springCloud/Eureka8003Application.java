package springCloud;

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
public class Eureka8003Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka8003Application.class, args);
    }
}
