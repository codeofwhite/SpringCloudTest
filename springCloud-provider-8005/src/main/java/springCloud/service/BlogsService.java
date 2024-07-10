package springCloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
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

    void likeBlog(String blogId, String userId);

    void unlikeBlog(String blogId, String userId);

    Long getLikesCount(String blogId);

    boolean checkLikeStatus(String blogId, String userId);

    void deleteBlog(String blogId);

    void updateBlog(@RequestBody Blogs blogs);
}
