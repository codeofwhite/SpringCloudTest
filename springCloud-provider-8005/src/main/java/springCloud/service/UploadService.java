package springCloud.service;

import org.springframework.web.multipart.MultipartFile;
import springCloud.utils.FileVO;

import java.rmi.ServerException;

/**
 * @author codeofwhite
 * @date 2024/6/23
 * @Description
 */
public interface UploadService {
    FileVO upload(MultipartFile file, String newFileName) throws ServerException;

    FileVO uploadImg(MultipartFile fileImg, String folderPath) throws ServerException;
}
