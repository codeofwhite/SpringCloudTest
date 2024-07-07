package springCloud.controller;

import springCloud.pojo.Dept;
import springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 拾万个为什么
 * @date 2021/2/24
 * @since JDK1.8
 */
@RestController
@CrossOrigin
public class Provider8001DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept selectDeptById(@PathVariable("id") int id) {
        return deptService.selectDeptById(id);
    }

    // 用来测试网关Gateway
    @GetMapping(value = "/get/{id}")
    public Dept getAllUser(@PathVariable("id") int id) {
        return deptService.selectDeptById(id);
    }

    @GetMapping(value = "/test/hello")
    public String test() {
        return "Hello";
    }
}