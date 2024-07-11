package springCloud.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author codeofwhite
 * @date 2024/6/23
 * @Description
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "minio.config")
public class MinioConfig {
    /**
     * 服务地址
     */
    @Value("${minio:url}")
    private String url;

    /**
     * 用户名
     */
    @Value("${minio:access-key}")
    private String accessKey;

    /**
     * 密码
     */
    @Value("${minio:secret-key}")
    private String secretKey;

    /**
     * 存储桶名称
     */
    @Value("${minio:bucket-name}")
    private String bucketName;

    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }
}
