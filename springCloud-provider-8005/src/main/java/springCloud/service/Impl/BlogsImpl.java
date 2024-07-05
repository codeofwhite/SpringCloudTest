package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}
