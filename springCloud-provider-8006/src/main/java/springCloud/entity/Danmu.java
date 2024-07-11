package springCloud.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * (Danmu)实体类
 *
 * @author makejava
 * @since 2024-07-03 22:41:06
 */
@Getter
@Setter
public class Danmu implements Serializable {
    private static final long serialVersionUID = -74827364115534879L;

    private Integer id;

    private String danmu;

    private String uemail;

    private Date createTime;

    private Integer blogId;

}

