package com.department.model;

import java.util.List;
import java.util.Set;

import com.department.model.DepartmentVO;
import com.employee.model.EmployeeVO;

public interface DepartmentDAO_interface {
    public void insert(DepartmentVO depVO);
    public void update(DepartmentVO depVO);
    public void delete(Integer depno);
    public DepartmentVO findByPrimaryKey(Integer depno);
    public List<DepartmentVO> getAll();
      //查詢某部門的員工(一對多)(回傳 Set)
    public Set<EmployeeVO> getEmpsByDeptno(Integer depno);

}

