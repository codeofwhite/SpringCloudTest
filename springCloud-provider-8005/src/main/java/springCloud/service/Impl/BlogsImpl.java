package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springCloud.entity.Blogs;
import springCloud.entity.Photos;
import springCloud.service.BlogsService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@Service("BlogsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BlogsImpl implements BlogsService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "blogs";

    @Override
    public void insertBlog(Blogs blogs) {
        mongoTemplate.save(blogs);
    }

    @Override
    public List<Blogs> getAllBlogs() {
        return mongoTemplate.findAll(Blogs.class, COLLECTION_NAME);
    }

    // 原子性地更新点赞数
    @Override
    public void likeBlog(String blogId, String userId) {
        Query query = new Query(Criteria.where("id").is(blogId).and("likedUserIds").ne(userId));
        Update update = new Update().addToSet("likedUserIds",userId).inc("likesCount", 1);
        mongoTemplate.findAndModify(query, update, Blogs.class, COLLECTION_NAME);
    }

    @Override
    public void unlikeBlog(String blogId, String userId) {
        Query query = new Query(Criteria.where("id").is(blogId));
        Update update = new Update().pull("likedUserIds", userId).inc("likesCount", -1);
        mongoTemplate.findAndModify(query, update, Blogs.class, COLLECTION_NAME);
    }

    @Override
    public Long getLikesCount(String blogId) {
        Blogs blog = mongoTemplate.findById(blogId, Blogs.class);
        assert blog != null;
        return blog.getLikesCount();
    }

    @Override
    public boolean checkLikeStatus(String blogId, String userId) {
        // 创建查询对象
        Query query = new Query();
        // 添加条件，检查blogId是否匹配
        query.addCriteria(Criteria.where("id").is(blogId));
        // 使用elemMatch操作符检查userId是否在likedUserIds数组中
        // 普通的如上面的查询是找不到的，要用elemMatch
        query.addCriteria(Criteria.where("likedUserIds").elemMatch(new Criteria().in(userId)));
        // 使用MongoTemplate的exists方法检查是否存在匹配的文档
        return mongoTemplate.exists(query, Blogs.class);
    }

    @Override
    public void deleteBlog(String blogId) {
        Query query = new Query(Criteria.where("id").is(blogId));
        mongoTemplate.remove(query, Blogs.class, COLLECTION_NAME);
    }
}
