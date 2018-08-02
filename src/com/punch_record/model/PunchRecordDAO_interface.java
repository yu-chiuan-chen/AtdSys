package com.punch_record.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.department.model.DepartmentVO;

public interface PunchRecordDAO_interface {
	  public void insert(PunchRecordVO empVO);
      public void update(PunchRecordVO empVO);
      public void delete(Integer empno);
      public PunchRecordVO findByPrimaryKey(Integer empno);
      public List<PunchRecordVO> getAll();
      //萬用複合查詢(傳入參數型態Map)(回傳 List)
      public List<PunchRecordVO> getAll(Map<String, String[]> map); 

}
