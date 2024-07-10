package springCloud.hystrix.controller;

import springCloud.hystrix.model.LoginRequest;
import springCloud.hystrix.model.LoginResponse;
import springCloud.hystrix.model.RegisterRequest;
import springCloud.hystrix.entity.User;
import springCloud.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    // 假设有一个用户服务来验证用户信息
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // 验证用户名和密码
        User user = userService.validateUser(loginRequest.getUemail(), loginRequest.getPassword());

        if (Objects.equals(loginRequest.getUemail(), user.getUemail())) {
            // 登录成功
            if (Objects.equals(loginRequest.getPassword(), user.getUpwd())) {
                return ResponseEntity.ok(new LoginResponse(user.getUemail(), true));
            } else {
                // 登录失败
                return ResponseEntity.ok(new LoginResponse("", false));
            }
        } else {
            // 登录失败
            return ResponseEntity.ok(new LoginResponse("", false));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // 验证用户名和密码
        User user = userService.validateUser(registerRequest.getUemail(), registerRequest.getPassword());

        if (user != null) {
            // 注册失败，用户已存在
            return ResponseEntity.ok(new LoginResponse("", false));
        } else {
            // 注册成功
            userService.register(registerRequest.getUsername(), registerRequest.getUemail(), registerRequest.getPassword());
            return ResponseEntity.ok(new LoginResponse(registerRequest.getUemail(), true));
        }
    }
}
