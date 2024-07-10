package springCloud.hystrix.mapper;

import org.apache.ibatis.annotations.Update;
import springCloud.hystrix.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Mapper
public interface UserMapper {
    User validateUser(@Param("uemail") String uemail, @Param("password") String password);

    void register(@Param("username") String username, @Param("uemail") String uemail, @Param("password") String password);

    List<User> getAllUser();

    User findByEmail(@Param("uemail") String uemail);

    void updateUser(User user);

    @Update("UPDATE users SET " +
            "uname = COALESCE(#{user.uname}, uname), " +
            "uemail = COALESCE(#{user.uemail}, uemail), " +
            "upwd = COALESCE(#{user.upwd}, upwd), " +
            "status = COALESCE(#{user.status}, status), " +
            "sex = COALESCE(#{user.sex}, sex), " +
            "avatar = COALESCE(#{user.avatar}, avatar), " +
            "utype = COALESCE(#{user.utype}, utype), " +
            "update_time = COALESCE(#{user.update_time}, update_time), " +
            "del_flag = COALESCE(#{user.del_flag}, del_flag) " +
            "WHERE id = #{user.id}")
    void adminUpdateUser(@Param("user") User user);
}
