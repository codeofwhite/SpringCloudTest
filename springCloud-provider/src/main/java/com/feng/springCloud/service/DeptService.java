package com.feng.springCloud.service;

import com.feng.springCloud.pojo.Dept;
import org.springframework.stereotype.Service;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */public interface DeptService {

    /**
     * 添加部门
     * @return bloolean
     */
    public boolean addDept(Dept dept);

    /**
     *  查询部门
     * @return Dept
     */
    public Dept selectDeptById(int id);
}