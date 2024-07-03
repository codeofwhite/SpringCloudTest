package springCloud.hystrix.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */
@Setter
@Getter
public class LoginRequest {
    private String uemail;
    private String password;
}
