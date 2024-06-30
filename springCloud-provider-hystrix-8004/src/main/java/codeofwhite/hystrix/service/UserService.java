package codeofwhite.hystrix.service;

import codeofwhite.hystrix.entry.User;

/**
 * @author codeofwhite
 * @date 2024/6/26
 * @Description
 */
public interface UserService {
    User validateUser(String username, String password);
}
