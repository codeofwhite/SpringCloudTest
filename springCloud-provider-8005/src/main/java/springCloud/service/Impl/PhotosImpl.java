package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springCloud.entity.Photos;
import springCloud.service.PhotosService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@Service("PhotosService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PhotosImpl implements PhotosService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "photos";

    @Override
    public List<Photos> getAllPhotos() {
        return mongoTemplate.findAll(Photos.class, COLLECTION_NAME);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void uploadPhoto(Photos photo) {
        mongoTemplate.insert(photo, COLLECTION_NAME);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePhoto(String photoId) {
        Query query = new Query(Criteria.where("id").is(photoId));
        mongoTemplate.remove(query, Photos.class, COLLECTION_NAME);
    }
}
