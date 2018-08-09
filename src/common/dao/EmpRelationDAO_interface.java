package common.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import common.vo.EmpRelationVO;

public interface EmpRelationDAO_interface {
	  public void insert(EmpRelationVO empVO);
      public void update(EmpRelationVO empVO);
      public void delete(EmpRelationVO ERVO);
      public EmpRelationVO findByPrimaryKey(Integer empno);
      public List<EmpRelationVO> getAll();
      //萬用複合查詢(傳入參數型態Map)(回傳 List)
      public List<EmpRelationVO> getAll(Map<String, String[]> map); 

}
