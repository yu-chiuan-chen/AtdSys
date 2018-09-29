package user.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import common.vo.ApplyTypeVO;

import common.dao.ApplyTypeDAO_interface;
import common.dao.ApplyTypeHibernateDAO;

public class ApplyTypeService {

	private ApplyTypeDAO_interface dao;

	public ApplyTypeService() {
		dao = new ApplyTypeHibernateDAO();
	}

	public ApplyTypeVO addAT(String name, String remarks) {

		ApplyTypeVO ATVO = new ApplyTypeVO();
		ATVO.setName(name);
		ATVO.setName(remarks);

		dao.insert(ATVO);

		return ATVO;
	}

	public ApplyTypeVO updateAT(Integer dep_no, String name, String remarks) {

		ApplyTypeVO ATVO = new ApplyTypeVO();
		ATVO.setAt_no(dep_no);
		ATVO.setName(name);
		ATVO.setName(remarks);

		dao.update(ATVO);
		return ATVO;
	}

	public void deleteAT(Integer at_no) {
		dao.delete(at_no);
	}

	public ApplyTypeVO getOneAT(Integer at_no) {
		return dao.findByPrimaryKey(at_no);
	}

	public List<ApplyTypeVO> getAll() {
		return dao.getAll();
	}

//	public List<ApplyTypeVO> getAll(Map<String, String[]> map) {
//		return dao.getAll(map);
//	}
}
