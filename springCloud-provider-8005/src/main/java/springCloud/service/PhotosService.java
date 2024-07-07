package springCloud.service;

import org.springframework.stereotype.Service;
import springCloud.entity.Photos;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@Service
public interface PhotosService {
    public List<Photos> getAllPhotos();
}
