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
    List<Photos> getAllPhotos();

    void uploadPhoto(Photos photo); // 添加上传图片的方法声明

    void deletePhoto(String photoId); // 添加删除照片的方法声明
}
