package springCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("springCloud.mapper")
public class Provider8001Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Provider8001Application.class, args);
    }
}