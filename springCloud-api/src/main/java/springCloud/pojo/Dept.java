package springCloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author codeofwhite
 * @date 2021/2/24
 * @since JDK1.8
 */

@Data
@Accessors(chain = true)  //启用链式结构
// 链式意味着可以 Dept dept = new Dept().setDeptNum(1).setName("Development");
@NoArgsConstructor  //给类提供一个无参构造函数
@TableName("dept")
// 实现 Serializable 接口，意味着可以被虚拟化
public class Dept implements Serializable {

    /**
     * 部门编号
     */
    private int deptNum;

    /**
     * 部门名称
     */
    private String name;

}