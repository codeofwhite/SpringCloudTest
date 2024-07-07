package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springCloud.service.UploadService;

import java.rmi.ServerException;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@RestController
@RequestMapping("img")
@CrossOrigin
public class ImgUploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestPart("fileImg") MultipartFile fileImg, @RequestPart("folderPath") String folderPath) throws ServerException {
        uploadService.uploadImg(fileImg, folderPath);
        return "success";
    }
}
