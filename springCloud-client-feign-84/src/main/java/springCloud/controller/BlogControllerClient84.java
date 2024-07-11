package springCloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springCloud.entity.Blogs;
import springCloud.model.BlogInsertRequest;
import springCloud.model.BlogUpdateRequest;
import springCloud.service.Provider8005Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/11
 * @Description
 */
@RestController
@RequestMapping("/client84/blogs")
@CrossOrigin
public class BlogControllerClient84 {

    @Resource
    private Provider8005Service provider8005Service;

    @PostMapping("/insertBlog")
    public String insertBlog(@RequestBody BlogInsertRequest blogInsertRequest) {
        provider8005Service.insertBlog(blogInsertRequest);
        return "success";
    }

    @GetMapping("/getAllBlogs")
    public List<Blogs> getAllBlogs() {
        return provider8005Service.getAllBlogs();
    }

    @PostMapping("/like")
    public ResponseEntity<?> like(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlike(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/getLikesCount")
    public Long getLikes(@RequestParam("blogId") String blogId) {
        return provider8005Service.getLikes(blogId);
    }

    @PostMapping("/checkLikeStatus")
    public ResponseEntity<?> checkLikeStatus(@RequestParam("blogId") String blogId,
                                             @RequestParam("userId") String userId) {
        provider8005Service.checkLikeStatus(blogId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable String id) {
        provider8005Service.deleteBlog(id);
        return "success";
    }

    @PostMapping("updateBlog")
    public String updateBlog(@RequestBody BlogUpdateRequest blogUpdateRequest) {
        provider8005Service.updateBlog(blogUpdateRequest);
        return "success";
    }
}
