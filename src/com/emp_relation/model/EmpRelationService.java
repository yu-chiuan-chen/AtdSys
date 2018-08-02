package com.emp_relation.model;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.emp_relation.model.EmpRelationVO;

public class EmpRelationService {

	private EmpRelationDAO_interface dao;

	public EmpRelationService() {
		dao = new EmpRelationHibernateDAO();
	}

	public EmpRelationVO addER(Integer emp_no, Integer mgr_no, Integer dir_mgr) {

		EmpRelationVO ERVO = new EmpRelationVO();
		ERVO.setEmp_no(emp_no);
		ERVO.setMgr_no(mgr_no);
		ERVO.setDir_mgr(dir_mgr);
		dao.insert(ERVO);

		return ERVO;
	}

	public EmpRelationVO updateER(Integer emp_no, Integer mgr_no, Integer dir_mgr) {

		EmpRelationVO ERVO = new EmpRelationVO();
		ERVO.setEmp_no(emp_no);
		ERVO.setMgr_no(mgr_no);
		ERVO.setDir_mgr(dir_mgr);
		dao.update(ERVO);

		return ERVO;
	}

	public void deleteER(Integer emp_no, Integer mgr_no) {
		EmpRelationVO ERVO = new EmpRelationVO();
		ERVO.setEmp_no(emp_no);
		ERVO.setMgr_no(mgr_no);
		dao.delete(ERVO);
	}

	public EmpRelationVO getOneER(Integer Er_no) {
		return dao.findByPrimaryKey(Er_no);
	}

	public List<EmpRelationVO> getAll() {
		return dao.getAll();
	}

	// public List<EmpRelationVO> getAll(Map<String, String[]> map) {
	// return dao.getAll(map);
	// }
}
