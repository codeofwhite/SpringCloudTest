package springCloud.hystrix.service.Impl;

import springCloud.hystrix.entity.User;
import springCloud.hystrix.mapper.UserMapper;
import springCloud.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.validateUser(uemail,password);
    }

    @Override
    public void register(String username, String uemail, String password) {
        userMapper.register(username, uemail, password);
    }
}
