package springCloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Mapper
public interface DanmuMapper {
    public void insertDanmu(@Param("danmu") String danmu,
                            @Param("uemail") String uemail, @Param("blogId") String blogId);

    public List<String> selectDanmu(@Param("blogId") String blogId);
}
