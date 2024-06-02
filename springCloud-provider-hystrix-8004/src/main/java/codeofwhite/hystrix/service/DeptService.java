package codeofwhite.hystrix.service;

/**
 * @author codeofwhite
 * @date 2024/6/1
 * @Description
 */
public interface DeptService {
    // hystrix 熔断器示例 ok
    public String deptInfo_Ok(Integer id);
    // hystrix 熔断器超时
    public String deptInfo_Timeout(Integer id);

    // Hystrix 熔断机制案例
    public String deptCircuitBreaker(Integer id);
}
