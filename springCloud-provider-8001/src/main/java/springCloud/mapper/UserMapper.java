package springCloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import springCloud.entry.User;
import org.springframework.stereotype.Service;

/**
 * @author codeofwhite
 * @date 2024/5/15
 * @Description
 */

@Service
public interface UserMapper extends BaseMapper<User> {
}
