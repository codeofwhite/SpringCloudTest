package springCloud.hystrix.service;

import springCloud.hystrix.entity.User;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */

public interface UserService {
    User validateUser(String uemail, String password);

    void register(String username , String uemail, String password);
}
