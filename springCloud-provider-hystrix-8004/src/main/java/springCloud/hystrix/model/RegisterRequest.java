package springCloud.hystrix.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Setter
@Getter
public class RegisterRequest {
    private String uemail;
    private String username;
    private String password;
}
