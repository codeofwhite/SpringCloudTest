package com.feng.springCloud.pojo;

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
@NoArgsConstructor  //给类提供一个无参构造函数
@TableName("dept")
public class Dept implements Serializable {

    /**
     *  部门编号
     */
    private int deptNum;

    /**
     *  部门名称
     */
    private String name;

}