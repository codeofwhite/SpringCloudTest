package springCloud.hystrix.mapper;

import springCloud.hystrix.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Mapper
public interface UserMapper {
    User validateUser(@Param("uemail") String uemail, @Param("password") String password);

    void register(@Param("username") String username ,@Param("uemail") String uemail, @Param("password") String password);
}
