package springCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springCloud.config.FeignSupportConfig;
import springCloud.entity.Blogs;
import springCloud.model.BlogInsertRequest;
import springCloud.model.BlogUpdateRequest;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/11
 * @Description
 */
// 使用@PathVariable注解但没有指定value属性时，会出现问题。
@Component
@FeignClient(value = "SPRING-CLOUD-PROVIDER-8005", configuration = FeignSupportConfig.class)
public interface Provider8005Service {
    @PostMapping("/blogs/insertBlog")
    public String insertBlog(BlogInsertRequest blogInsertRequest);

    @GetMapping("/blogs/getAllBlogs")
    public List<Blogs> getAllBlogs();

    @PostMapping("/blogs/like")
    public ResponseEntity<?> like(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId);

    @PostMapping("/blogs/unlike")
    public ResponseEntity<?> unlike(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId);

    @PostMapping("/blogs/getLikesCount")
    public Long getLikes(@RequestParam("blogId") String blogId);

    @PostMapping("/blogs/checkLikeStatus")
    public ResponseEntity<?> checkLikeStatus(@RequestParam("blogId") String blogId,
                                             @RequestParam("userId") String userId);

    // PathVariable要指明参数
    @DeleteMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") String id);

    @PostMapping("/blogs/updateBlog")
    public String updateBlog(@RequestBody BlogUpdateRequest blogUpdateRequest);
}
