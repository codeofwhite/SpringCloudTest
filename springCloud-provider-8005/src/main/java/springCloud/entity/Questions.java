package springCloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author codeofwhite
 * @date 2024/6/30
 * @Description
 */
@Document(collection="questions")
@Setter
@Getter
public class Questions {
    // 设置成String才能自动生成
    @Id
    private String id;

    private String userEmail;

    private String question;

    private Date createDate;

    private Date updateDate;

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", user_email='" + userEmail + '\'' +
                ", question='" + question + '\'' +
                ", create_date=" + createDate +
                ", update_date=" + updateDate +
                '}';
    }
}
