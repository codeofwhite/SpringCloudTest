package springCloud.hystrix.service.Impl;

import springCloud.hystrix.entity.User;
import springCloud.hystrix.mapper.UserMapper;
import springCloud.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User validateUser(String uemail, String password) {
        return userMapper.validateUser(uemail, password);
    }

    @Override
    public void register(String username, String uemail, String password) {
        userMapper.register(username, uemail, password);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User findByEmail(String uemail) {
        return userMapper.findByEmail(uemail);
    }

    @Override
    public boolean updateUserInformation(String uemail, String username, String password, String sex) {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());

        User user = userMapper.findByEmail(uemail);
        if (user != null) {
            user.setUname(username);
            user.setUpwd(password);
            user.setSex(sex);
            user.setUpdate_time(currentDate); // 更新update_time字段
            userMapper.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void adminUpdateUser(User user) {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());

        User existingUser = userMapper.findByEmail(user.getUemail());
        if (existingUser != null) {
            existingUser.setUname(user.getUname());
            existingUser.setUpwd(user.getUpwd());
            existingUser.setStatus(user.getStatus());
            existingUser.setSex(user.getSex());
            existingUser.setAvatar(user.getAvatar());
            existingUser.setUtype(user.getUtype());
            existingUser.setUpdate_time(currentDate); // 更新update_time字段
            existingUser.setDel_flag(user.getDel_flag());
            userMapper.updateUser(existingUser);
        }
    }
}
