package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springCloud.entity.Photos;
import springCloud.service.PhotosService;
import springCloud.service.UploadService;

import java.rmi.ServerException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@RestController
@RequestMapping("photos")
public class PhotoController {
    @Autowired
    PhotosService photosService;

    @Autowired
    private UploadService uploadService;

    @GetMapping("/getAllPhotos")
    public List<Photos> getAllPhotos() {
        return photosService.getAllPhotos();
    }


    @PostMapping("/uploadPhoto")
    public String uploadPhoto(@RequestPart("photo") Photos photo,
                              @RequestPart("fileImg") MultipartFile fileImg,
                              @RequestPart("folderPath") String folderPath) throws ServerException {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        Photos photo1 = new Photos();

        // 获取文件真实名称
        String originalFilename = fileImg.getOriginalFilename();
        // 使用传入的文件夹路径和文件名构建对象名称
        String objectName = folderPath + originalFilename;

        photo1.setAlt(photo.getAlt());
        photo1.setSrc(objectName);
        photo1.setUpdateDate(currentDate);
        photo1.setCreateDate(currentDate);

        photosService.uploadPhoto(photo1);
        uploadService.uploadImg(fileImg, folderPath);
        return "success";
    }

    @DeleteMapping("/deletePhoto/{id}")
    public String deletePhoto(@PathVariable String id) {
        photosService.deletePhoto(id);
        return "success";
    }
}
