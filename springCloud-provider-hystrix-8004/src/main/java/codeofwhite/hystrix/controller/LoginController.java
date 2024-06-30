package codeofwhite.hystrix.controller;

import codeofwhite.hystrix.entry.LoginRequest;
import codeofwhite.hystrix.entry.LoginResponse;
import codeofwhite.hystrix.entry.User;
import codeofwhite.hystrix.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */
@RestController
@CrossOrigin
public class LoginController {
    // 假设有一个用户服务来验证用户信息
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // 验证用户名和密码
        // User user = userService.validateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (Objects.equals(loginRequest.getUsername(), "99gelanjingling@gmail.com")) {
            // 登录成功
            return ResponseEntity.ok(new LoginResponse("99gelanjingling@gmail.com", true));
        } else {
            // 登录失败
            return ResponseEntity.ok(new LoginResponse("", false));
        }
    }
}
