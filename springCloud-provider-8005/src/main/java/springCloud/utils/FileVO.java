package springCloud.utils;

import lombok.Data;

/**
 * @author codeofwhite
 * @date 2024/6/23
 * @Description
 */

@Data
public class FileVO {
    private String url;

    private String fileName;

    private Long size;

    private String extname;
}
