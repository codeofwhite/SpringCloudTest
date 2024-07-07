package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springCloud.entity.Blogs;
import springCloud.entity.GaveMe;
import springCloud.service.GaveMeService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@Service("GaveMeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GaveMeImpl implements GaveMeService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "gaveme";

    @Override
    public void insertGaveMe(GaveMe gaveMe) {
        mongoTemplate.save(gaveMe);
    }

    @Override
    public List<GaveMe> getAllGaveMe() {
        return mongoTemplate.findAll(GaveMe.class, COLLECTION_NAME);
    }
}
