package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springCloud.entity.Blogs;
import springCloud.service.BlogsService;
import springCloud.service.UploadService;
import springCloud.utils.FileVO;

import java.rmi.ServerException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@RestController
@RequestMapping("blogs")
@CrossOrigin
public class BlogController {
    @Autowired
    BlogsService blogsService;

    @Autowired
    private UploadService uploadService;

    @PostMapping("/insertBlog")
    public String insertBlog(@RequestPart("blogs") Blogs blogs, @RequestPart("file") MultipartFile file,
                             @RequestPart("blogImg") MultipartFile blogImg) throws ServerException {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        // 获取博客标题并处理成适合作为文件名的格式
        // String title = blogs.getTitle().replaceAll("\\s+", "_"); // 替换空格为下划线
        // 生成一个短的随机字符串
        // String randomStr = UUID.randomUUID().toString().substring(0, 8);
        // 将处理过的标题和随机字符串结合生成博客ID
        // String blogId = title + "_" + randomStr;
        Blogs blogs1 = new Blogs();
        blogs1.setTitle(blogs.getTitle());
        blogs1.setCategory(blogs.getCategory());
        blogs1.setCreateDate(currentDate);
        blogs1.setUpdateDate(currentDate);

        // 生成新的文件名，例如使用UUID
        String blogId = UUID.randomUUID().toString();
        String newFileName = blogId + ".md";
        String folderPath = "markdowns/"; // 想上传到的文件夹路径
        newFileName = folderPath + newFileName;

        blogs1.setId(blogId);

        // 需要插入minio里面
        // 调用上传服务将文件上传到MinIO
        uploadService.upload(file, newFileName);

        // 图片路径
        // 获取真实路径，不是getName
        String blogImgName = blogImg.getOriginalFilename();
        String ImgFolderPath = "images/blogImg/";
        String newImgFileName = ImgFolderPath + blogImgName;

        // 设置博客图片位置
        blogs1.setImgSrc(newImgFileName);

        // 插入博客到数据库
        blogsService.insertBlog(blogs1);

        // 插入图片，第二个参数是folder名
        uploadService.uploadImg(blogImg, ImgFolderPath);

        return blogs.getId();
    }

    @GetMapping("/getAllBlogs")
    public List<Blogs> getAllBlogs() {
        return blogsService.getAllBlogs();

    }

    @PostMapping("/like")
    public ResponseEntity<?> like(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId) {
        blogsService.likeBlog(blogId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlike(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId) {
        blogsService.unlikeBlog(blogId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/getLikesCount")
    public Long getLikes(@RequestParam("blogId") String blogId) {
        return blogsService.getLikesCount(blogId);
    }

    @PostMapping("/checkLikeStatus")
    public ResponseEntity<?> checkLikeStatus(@RequestParam("blogId") String blogId,
                                             @RequestParam("userId") String userId) {
        boolean isLiked = blogsService.checkLikeStatus(blogId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable String id) {
        blogsService.deleteBlog(id);
        return "success";
    }

    @PostMapping("updateBlog")
    public String updateBlog(@RequestPart Blogs blogs, @RequestPart MultipartFile markDownFile) throws ServerException {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());

        System.out.println(blogs.getId());
        System.out.println(blogs.getTitle());
        System.out.println(blogs.getCategory());

        blogs.setUpdateDate(currentDate);
        blogsService.updateBlog(blogs);
        String newFileName = blogs.getId() + ".md";
        String folderPath = "markdowns/"; // 想上传到的文件夹路径
        newFileName = folderPath + newFileName;

        // 需要插入minio里面
        // 调用上传服务将文件上传到MinIO
        uploadService.upload(markDownFile, newFileName);

        return "success";
    }
}
