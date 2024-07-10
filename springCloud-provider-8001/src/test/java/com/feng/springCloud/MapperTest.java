package com.feng.springCloud;

import springCloud.entry.User;
import springCloud.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/11 0011 20:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)//这行必须加
public class MapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        //查询所有用户
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}