package springCloud.service;

import org.springframework.stereotype.Service;
import springCloud.entity.Comments;
import springCloud.entity.Questions;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Service
public interface CommentsService {
    public void insertComment(Comments comments);

    public List<Comments> getAllComments(String blogId);
}
