package springCloud.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springCloud.hystrix.entity.User;
import springCloud.hystrix.service.UserService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/8
 * @Description
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/findByEmail")
    public User findByEmail(@RequestParam("uemail") String uemail) {
        return userService.findByEmail(uemail);
    }

    @PostMapping("updateUserInformation")
    public String updateUserInformation(String uemail, String username, String password, String sex) {
        userService.updateUserInformation(uemail, username, password, sex);
        return "success";
    }

    @PutMapping("/adminUpdate")
    public String updateUser(@RequestBody User user) {
        userService.adminUpdateUser(user);
        ;
        return "success";
    }
}
