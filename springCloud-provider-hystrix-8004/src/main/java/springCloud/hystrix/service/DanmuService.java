package springCloud.hystrix.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
public interface DanmuService {
    public void insertDanmu(String danmu, String uemail, String blogId);

    public List<String> selectDanmu(@Param("blogId") String blogId);
}
