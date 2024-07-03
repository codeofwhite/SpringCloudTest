package springCloud.mapper;

import springCloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shiwangeweishenme
 * @date 2021/2/24
 * @since JDK1.8
 */
@Mapper
public interface DeptMapper {

    /**
     * 添加部门
     * @return bloolean
     */
    public boolean addDept(Dept dept);

    /**
     *  查询部门
     * @return Dept
     */
    public Dept slel(int id);
}