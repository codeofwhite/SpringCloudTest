package springCloud.hystrix.service.Impl;

import springCloud.hystrix.mapper.DanmuMapper;
import springCloud.hystrix.service.DanmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Service
public class DanmuServiceImpl implements DanmuService {
    @Autowired
    DanmuMapper danmuMapper;

    @Override
    public void insertDanmu(String danmu, String uemail, String blogId){
        danmuMapper.insertDanmu(danmu,uemail,blogId);
    }

    @Override
    public List<String> selectDanmu(String blogId) {
        return danmuMapper.selectDanmu(blogId);
    }
}
