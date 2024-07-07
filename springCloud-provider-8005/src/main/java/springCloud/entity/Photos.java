package springCloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author codeofwhite
 * @date 2024/7/4
 * @Description
 */
@Document(collection="photos")
@Setter
@Getter
public class Photos {
    // 设置成String才能自动生成
    @Id
    private String id;

    private String src;

    private String alt;

    private Date createDate;

    private Date updateDate;

    @Override
    public String toString() {
        return "Photos{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", alt='" + alt + '\'' +
                ", create_date=" + createDate +
                ", update_date=" + updateDate +
                '}';
    }
}
