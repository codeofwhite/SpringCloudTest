package springCloud.controller;

import springCloud.service.DeptFeignService;
import springCloud.pojo.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author codeofwhite
 * @date 2024/6/1
 * @Description
 */
@RestController
public class DeptController_Client {
    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/client81/dept/get/{id}")
    public Dept selectDeptById(@PathVariable("id") Integer id) {
         return deptFeignService.selectDeptById(id);
    }

    @GetMapping(value = "client81/test/hello")
    public String test(){
        return deptFeignService.test();
    }
}
