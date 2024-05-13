package shiwangeweishenme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 拾万个为什么
 * @date 2021/3/4
 * @since JDK1.8
 */
@SpringBootApplication
//表示这个服务可以接受别人注册
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class , args);
    }
}