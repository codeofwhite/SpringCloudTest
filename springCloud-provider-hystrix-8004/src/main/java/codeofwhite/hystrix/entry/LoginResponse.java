package codeofwhite.hystrix.entry;

import lombok.Getter;
import lombok.Setter;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */
@Setter
@Getter
public class LoginResponse {
    private String uemail;
    private boolean success;

    public LoginResponse(String uemail, boolean success) {
        this.uemail = uemail;
        this.success = success;
    }
}
