package com.feng.springCloud.controller;

import com.feng.springCloud.pojo.Dept;
import com.feng.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept selectDeptById(@PathVariable("id") int id){
        return deptService.selectDeptById(id);
    }

}