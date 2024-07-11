package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springCloud.entity.Comments;
import springCloud.model.Reply;
import springCloud.service.CommentsService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Service("CommentsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CommentsImpl implements CommentsService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "comments";

    @Override
    public void insertComment(Comments comments) {
        mongoTemplate.save(comments);
    }

    @Override
    public List<Comments> getAllComments(String blogId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("blogId").is(blogId));
        return mongoTemplate.find(query, Comments.class, COLLECTION_NAME);
    }

    @Override
    public Comments addReply(String commentId, Reply reply) {
        Query query = new Query(Criteria.where("_id").is(commentId));
        Update update = new Update().push("replies", reply);
        mongoTemplate.findAndModify(query, update, Comments.class, COLLECTION_NAME);
        return mongoTemplate.findById(commentId, Comments.class, COLLECTION_NAME);
    }
}
