package com.apply_type.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.department.model.DepartmentVO;
import com.employee.model.EmployeeVO;

public interface ApplyTypeDAO_interface {
	  public void insert(ApplyTypeVO empVO);
      public void update(ApplyTypeVO empVO);
      public void delete(Integer empno);
      public ApplyTypeVO findByPrimaryKey(Integer empno);
      public List<ApplyTypeVO> getAll();
      //萬用複合查詢(傳入參數型態Map)(回傳 List)
//      public List<ApplyTypeVO> getAll(Map<String, String[]> map); 
//	  public Set<EmployeeVO> getEmpsByAtno(Integer at_no);

}
