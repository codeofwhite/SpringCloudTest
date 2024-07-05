package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springCloud.entity.Photos;
import springCloud.entity.Questions;
import springCloud.service.PhotosService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@RestController
@RequestMapping("photos")
@CrossOrigin
public class PhotoController {
    @Autowired
    PhotosService photosService;

    @GetMapping("/getAllPhotos")
    public List<Photos> getAllPhotos() {
        return photosService.getAllPhotos();
    }
}
