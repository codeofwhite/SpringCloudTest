package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springCloud.entity.GaveMe;
import springCloud.service.GaveMeService;
import springCloud.service.UploadService;

import java.rmi.ServerException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@RestController
@RequestMapping("gaveme")
public class GaveMeController {

    @Autowired
    GaveMeService gaveMeService;

    @Autowired
    private UploadService uploadService;

    @PostMapping("/insertGaveMe")
    public String insertGaveMe(@RequestPart("gaveMe") GaveMe gaveMe,
                               @RequestPart("fileImg") MultipartFile fileImg,
                               @RequestPart("folderPath") String folderPath) throws ServerException {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        GaveMe gaveMe1 = new GaveMe();

        // 处理
        // 获取文件真实名称
        String originalFilename = fileImg.getOriginalFilename();
        // 使用传入的文件夹路径和文件名构建对象名称
        String objectName = folderPath + originalFilename;

        gaveMe1.setImgSrc(objectName);
        gaveMe1.setUserEmail(gaveMe.getUserEmail());
        gaveMe1.setCreateDate(currentDate);
        gaveMe1.setUpdateDate(currentDate);
        gaveMe1.setContent(gaveMe.getContent());

        // 插入图片数据到数据库
        gaveMeService.insertGaveMe(gaveMe1);

        // 需要插入minio里面
        // 调用上传服务将文件上传到MinIO
        uploadService.uploadImg(fileImg, folderPath);

        return "success";
    }

    @GetMapping("/getAllGaveMe")
    public List<GaveMe> getAllGaveMe() {
        return gaveMeService.getAllGaveMe();
    }
}
