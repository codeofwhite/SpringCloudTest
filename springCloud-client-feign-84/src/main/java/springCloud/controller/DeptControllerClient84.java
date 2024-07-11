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
@RequestMapping("/client84")
public class DeptControllerClient84 {
    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/dept/get/{id}")
    public Dept selectDeptById(@PathVariable("id") Integer id) {
        return deptFeignService.selectDeptById(id);
    }

    @GetMapping(value = "/test/hello")
    public String test() {
        return deptFeignService.test();
    }
}
