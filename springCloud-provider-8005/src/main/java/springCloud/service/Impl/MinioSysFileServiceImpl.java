package springCloud.service.Impl;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springCloud.config.MinioConfig;
import springCloud.service.UploadService;
import springCloud.utils.FileVO;

import java.rmi.ServerException;

/**
 * @author codeofwhite
 * @date 2024/6/23
 * @Description
 */


@Slf4j
@Service
public class MinioSysFileServiceImpl implements UploadService {
    // 注入minio配置文件
    @Autowired
    private MinioConfig minioConfig;

    // 注入minio client
    @Autowired
    private MinioClient client;

    @Override
    public FileVO upload(MultipartFile file, String newFileName) throws ServerException {
        FileVO fileVO = new FileVO();
        try {
            // 获取文件真实名称
            String originalFilename = file.getOriginalFilename();
            // 使用传入的文件夹路径和文件名构建对象名称
            // String objectName = folderPath + originalFilename;
            // 获取文件的扩展名 例如.jpg .doc
            String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 构建文件上传相关信息
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())
                    .object(newFileName)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();
            // 将文件上传到minio服务器
            // 6-23 这里会出错
            System.out.println("测试点");
            client.putObject(args);
            log.info("文件上传成功");
            // 组装文件信息，返回前端 或者存入数据路
            String url = minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + newFileName;
            fileVO.setUrl(url);
            fileVO.setSize(file.getSize());
            fileVO.setFileName(newFileName);
            fileVO.setExtname(extname);
        } catch (Exception e) {
            throw new ServerException("文件上传异常" + e.getCause().toString());
        }
        return fileVO;
    }

    @Override
    public FileVO uploadImg(MultipartFile fileImg, String folderPath) throws ServerException {
        FileVO fileVO = new FileVO();
        try {
            // 获取文件真实名称
            String originalFilename = fileImg.getOriginalFilename();
            // 使用传入的文件夹路径和文件名构建对象名称
            String objectName = folderPath + originalFilename;
            // 获取文件的扩展名 例如.jpg .doc
            String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 构建文件上传相关信息
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())
                    .object(objectName)
                    .stream(fileImg.getInputStream(), fileImg.getSize(), -1)
                    .contentType(fileImg.getContentType())
                    .build();
            // 将文件上传到minio服务器
            // 6-23 这里会出错
            System.out.println("测试点");
            client.putObject(args);
            log.info("文件上传成功");
            // 组装文件信息，返回前端 或者存入数据路
            String url = minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + objectName;
            fileVO.setUrl(url);
            fileVO.setSize(fileImg.getSize());
            fileVO.setFileName(objectName);
            fileVO.setExtname(extname);
        } catch (Exception e) {
            throw new ServerException("文件上传异常" + e.getCause().toString());
        }
        return fileVO;
    }
}
