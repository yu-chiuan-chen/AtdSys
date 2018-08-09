package common.dao;

import java.util.List;
import java.util.Set;

import common.vo.DepartmentVO;
import common.vo.EmployeeVO;

public interface DepartmentDAO_interface {
    public void insert(DepartmentVO depVO);
    public void update(DepartmentVO depVO);
    public void delete(Integer depno);
    public DepartmentVO findByPrimaryKey(Integer depno);
    public List<DepartmentVO> getAll();
      //查詢某部門的員工(一對多)(回傳 Set)
    public Set<EmployeeVO> getEmpsByDeptno(Integer depno);

}

