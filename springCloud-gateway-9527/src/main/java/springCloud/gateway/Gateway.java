package springCloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author codeofwhite
 * @date 2024/5/29
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway{
    public static void main(String[] args) {
        SpringApplication.run(Gateway.class,args);
    }
}
