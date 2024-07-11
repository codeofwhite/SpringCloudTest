package springCloud.service;

import org.springframework.stereotype.Service;
import springCloud.entity.Comments;
import springCloud.model.Reply;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Service
public interface CommentsService {
    void insertComment(Comments comments);

    List<Comments> getAllComments(String blogId);

    Comments addReply(String commentId, Reply reply);
}
