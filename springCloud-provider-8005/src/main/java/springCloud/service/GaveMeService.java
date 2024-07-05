package springCloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import springCloud.entity.Blogs;
import springCloud.entity.GaveMe;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@Service
public interface GaveMeService {
    void insertGaveMe(@RequestBody GaveMe gaveMe);

    List<GaveMe> getAllGaveMe();
}
