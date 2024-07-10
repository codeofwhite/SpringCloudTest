package springCloud.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@Document(collection = "comments")
@Setter
@Getter
public class Comments {
    // 设置成String才能自动生成
    @Id
    private String id;

    private String userEmail;

    private String comment;

    private Date createDate;

    private Date updateDate;

    private String blogId;

    private List<Reply> replies; // 新增回复列表字段

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", user_email='" + userEmail + '\'' +
                ", comment='" + comment + '\'' +
                ", create_date=" + createDate +
                ", update_date=" + updateDate +
                ", blog_id=" + blogId +
                ", replies=" + replies +
                '}';
    }
}
