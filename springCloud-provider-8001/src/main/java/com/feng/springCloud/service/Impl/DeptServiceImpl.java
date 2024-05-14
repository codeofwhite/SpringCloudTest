package com.feng.springCloud.service.Impl;

import com.feng.springCloud.mapper.DeptMapper;
import com.feng.springCloud.pojo.Dept;
import com.feng.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept selectDeptById(int id) {
        return deptMapper.slel(id);
    }
}