package springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author codeofwhite
 * @date 2024/6/30
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient //开启 Eureka 客户端功能
public class Provider8005Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider8005Application.class, args);
    }
}
