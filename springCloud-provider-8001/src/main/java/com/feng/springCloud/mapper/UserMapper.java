package com.feng.springCloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.springCloud.entry.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author codeofwhite
 * @date 2024/5/15
 * @Description
 */

@Service
public interface UserMapper extends BaseMapper<User> {
}
