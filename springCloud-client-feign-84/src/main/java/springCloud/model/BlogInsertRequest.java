package springCloud.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import springCloud.entity.Blogs;

/**
 * @author codeofwhite
 * @date 2024/7/11
 * @Description
 */
@Getter
@Setter
public class BlogInsertRequest {
    private Blogs blogs;
    private MultipartFile file;
    private MultipartFile blogImg;
}
