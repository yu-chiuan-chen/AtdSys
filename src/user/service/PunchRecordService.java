package user.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import common.vo.ApplyTypeVO;
import common.vo.EmployeeVO;
import common.vo.PunchRecordVO;
import common.dao.PunchRecordDAO_interface;
import common.dao.PunchRecordHibernateDAO;

public class PunchRecordService {

	private PunchRecordDAO_interface dao;

	public PunchRecordService() {
		dao = new PunchRecordHibernateDAO();
	}

	public PunchRecordVO addPR(EmployeeVO empVO, Integer type_no, Date pr_time, String remarks) {

		PunchRecordVO PRVO = new PunchRecordVO();
		
		PRVO.setEmpVO(empVO);
		PRVO.setType_no(type_no);
		PRVO.setPr_time(pr_time);
		PRVO.setRemarks(remarks);
		dao.insert(PRVO);
		
		return PRVO;
	}

	public PunchRecordVO updatePR(Integer pr_no,Integer emp_no, Integer type_no, Date pr_time, String remarks) {

		PunchRecordVO PRVO = new PunchRecordVO();
		EmployeeVO empVO = new EmployeeVO();
		
		empVO.setEmp_no(emp_no);
		PRVO.setPr_no(pr_no);
		PRVO.setEmpVO(empVO);
		PRVO.setType_no(type_no);
		PRVO.setPr_time(pr_time);
		PRVO.setRemarks(remarks);
		dao.update(PRVO);
		
		return PRVO;
	}

	public void deletePR(Integer empno) {
		dao.delete(empno);
	}

	public List<PunchRecordVO> getPRs(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<PunchRecordVO> getAll() {
		return dao.getAll();
	}

	// public List<PunchRecordVO> getAll(Map<String, String[]> map) {
	// return dao.getAll(map);
	// }
	
	
//	public static void main(String[] args) {
//		PunchRecordVO PRVO = new PunchRecordVO();
//		EmployeeService empService = new EmployeeService();
//
//		PunchRecordService PRService = new PunchRecordService();
//		EmployeeVO empVO = empService.getOneEmp(1);
//
//		PRVO.setType_no(1);
//		PRVO.setEmpVO(empVO);
//		PRVO.setPr_time(new Date());
//		PRService.addPR(emp_no, type_no, pr_time, remarks)
//	}
}
