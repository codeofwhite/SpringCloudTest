package springCloud.service;

import springCloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author codeofwhite
 * @date 2024/6/1
 * @Description
 */
//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "SPRINGCLOUD-PROVIDER-8001")
public interface DeptFeignService {
    //对应服务提供者8001 Controller 中定义的方法
    @GetMapping(value = "/dept/get/{id}")
    public Dept selectDeptById(@PathVariable("id") int id);

    @GetMapping(value = "/test/hello")
    public String test();
}
