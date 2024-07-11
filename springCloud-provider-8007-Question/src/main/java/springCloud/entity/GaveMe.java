package springCloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author codeofwhite
 * @date 2024/7/5
 * @Description
 */
@Document(collection = "gaveme")
@Setter
@Getter
public class GaveMe {
    @Id
    private String id;

    private String imgSrc;

    private String content;

    private String userEmail;

    private Date createDate;

    private Date updateDate;

    @Override
    public String toString() {
        return "GaveMe{" +
                "id=" + id +
                ", imgSrc='" + imgSrc + '\'' +
                ", title='" + content + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", create_date=" + createDate +
                ", update_date=" + updateDate +
                '}';
    }
}
