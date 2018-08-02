package com.employee.model;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.department.model.DepartmentVO;

public class EmployeeService {

	private EmployeeDAO_interface dao;

	public EmployeeService() {
		dao = new EmployeeHibernateDAO();
	}

	public EmployeeVO addEmp(String name, String title, Date fir_day, Date las_day, Date birthday, byte[] photo,
			String email, String psw, String is_mgr, String remrks, Integer dep_no) {

		EmployeeVO empVO1 = new EmployeeVO();
		DepartmentVO depVO = new DepartmentVO();
		depVO.setDep_no(dep_no);

		empVO1.setName(name);
		empVO1.setTitle(title);
		empVO1.setFir_day(fir_day);
		empVO1.setLas_day(las_day);
		empVO1.setBirthday(birthday);
		empVO1.setPhoto(photo);
		empVO1.setEmail(email);
		empVO1.setPsw(psw);
		empVO1.setIs_mgr(is_mgr);
		empVO1.setRemarks(remrks);
		empVO1.setDepVO(depVO);
		dao.insert(empVO1);

		return empVO1;
	}

	public EmployeeVO updateEmp(Integer emp_no, String name, String title, Date fir_day, Date las_day, Date birthday,
			byte[] photo, String email, String psw, String is_mgr, String remrks, Integer dep_no) {

		EmployeeVO empVO1 = new EmployeeVO();
		DepartmentVO depVO = new DepartmentVO();
		depVO.setDep_no(dep_no);

		empVO1.setEmp_no(emp_no);
		empVO1.setName(name);
		empVO1.setTitle(title);
		empVO1.setFir_day(fir_day);
		empVO1.setLas_day(las_day);
		empVO1.setBirthday(birthday);
		empVO1.setPhoto(photo);
		empVO1.setEmail(email);
		empVO1.setPsw(psw);
		empVO1.setIs_mgr(is_mgr);
		empVO1.setRemarks(remrks);
		empVO1.setDepVO(depVO);
		dao.insert(empVO1);

		return empVO1;
	}

	public void deleteEmp(Integer empno) {
		dao.delete(empno);
	}

	public EmployeeVO getOneEmp(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}

	public List<EmployeeVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}
