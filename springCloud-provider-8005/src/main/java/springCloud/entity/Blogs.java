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
@Document(collection="blogs")
@Setter
@Getter
public class Blogs {
    @Id
    private String id;

    private String imgSrc;

    private String title;

    private String category;

    private Date createDate;

    private Date updateDate;

    @Override
    public String toString() {
        return "Blogs{" +
                "id=" + id +
                ", imgSrc='" + imgSrc + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", create_date=" + createDate +
                ", update_date=" + updateDate +
                '}';
    }

}
