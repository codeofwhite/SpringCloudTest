package springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author codeofwhite
 * @date 2024/6/1
 * @Description
 */
@EnableEurekaClient
@EnableFeignClients // 开启Feign
// 这边我们不连数据库
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 启动而无需连接数据库，不加这个会报错，如果不连的话
public class Client81Application {
    public static void main(String[] args) {
        SpringApplication.run(Client81Application.class, args);
    }
}
