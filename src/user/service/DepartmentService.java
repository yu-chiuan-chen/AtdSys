package user.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import common.dao.DepartmentDAO_interface;
import common.dao.DepartmentHibernateDAO;
import common.vo.DepartmentVO;

public class DepartmentService {

	private DepartmentDAO_interface dao;

	public DepartmentService() {
		dao = new DepartmentHibernateDAO();
	}

	public DepartmentVO addDep(String name, String remarks) {

		DepartmentVO depVO = new DepartmentVO();
		depVO.setName(name);
		depVO.setName(remarks);

		dao.insert(depVO);

		return depVO;
	}

	public DepartmentVO updateDep(Integer dep_no, String name, String remarks) {

		DepartmentVO depVO = new DepartmentVO();
		depVO.setDep_no(dep_no);
		depVO.setName(name);
		depVO.setName(remarks);

		dao.update(depVO);
		return depVO;
	}

	public void deleteDep(Integer empno) {
		dao.delete(empno);
	}

	public DepartmentVO getOneDep(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<DepartmentVO> getAll() {
		return dao.getAll();
	}

//	public List<DepartmentVO> getAll(Map<String, String[]> map) {
//		return dao.getAll(map);
//	}
}
