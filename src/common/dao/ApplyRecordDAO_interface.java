package common.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import common.vo.ApplyRecordVO;

public interface ApplyRecordDAO_interface {
	  public void insert(ApplyRecordVO empVO);
      public void update(ApplyRecordVO empVO);
      public void delete(Integer empno);
      public ApplyRecordVO findByPrimaryKey(Integer empno);
      public List<ApplyRecordVO> getAll();
      //萬用複合查詢(傳入參數型態Map)(回傳 List)
      public List<ApplyRecordVO> getAll(Map<String, String[]> map); 

}
