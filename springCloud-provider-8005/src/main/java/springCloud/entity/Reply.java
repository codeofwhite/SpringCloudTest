package springCloud.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author codeofwhite
 * @date 2024/7/11
 * @Description
 */
@Getter
@Setter
public class Reply {
    private long id;
    private String userEmail;
    private String reply;
    private Date createDate;
}
