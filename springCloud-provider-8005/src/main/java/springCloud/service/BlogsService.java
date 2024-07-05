package springCloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import springCloud.entity.Blogs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@Service
public interface BlogsService {
    void insertBlog(@RequestBody Blogs blogs);

    List<Blogs> getAllBlogs();
}
