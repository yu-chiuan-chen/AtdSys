package user.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Date;

import common.vo.ApplyRecordVO;

import common.dao.ApplyRecordDAO_interface;
import common.dao.ApplyRecordHibernateDAO;

public class ApplyRecordService {

	private ApplyRecordDAO_interface dao;

	public ApplyRecordService() {
		dao = new ApplyRecordHibernateDAO();
	}

	public ApplyRecordVO addAR(Integer emp_no, Integer at_no, Date app_date, Date sta_time, Date end_time,
			Integer review, String remarks, String reason) {

		ApplyRecordVO ARVO = new ApplyRecordVO();
		ARVO.setEmp_no(emp_no);
		ARVO.setAt_no(at_no);
		ARVO.setApp_date(app_date);
		ARVO.setSta_time(sta_time);
		ARVO.setEnd_time(end_time);
		ARVO.setReview(review);
		ARVO.setRemarks(remarks);
		ARVO.setReason(reason);
		dao.insert(ARVO);

		return ARVO;
	}

	public ApplyRecordVO updateAR(Integer ar_no,Integer emp_no, Integer at_no, Date app_date, Date sta_time, Date end_time,
			Integer review, String remarks, String reason) {

		ApplyRecordVO ARVO = new ApplyRecordVO();
		ARVO.setAr_no(ar_no);
		ARVO.setEmp_no(emp_no);
		ARVO.setAt_no(at_no);
		ARVO.setApp_date(app_date);
		ARVO.setSta_time(sta_time);
		ARVO.setEnd_time(end_time);
		ARVO.setReview(review);
		ARVO.setRemarks(remarks);
		ARVO.setReason(reason);
		dao.update(ARVO);

		return ARVO;
	}

	public void deleteAR(Integer Ar_no) {
		dao.delete(Ar_no);
	}

	public ApplyRecordVO getOneAR(Integer Ar_no) {
		return dao.findByPrimaryKey(Ar_no);
	}

	public List<ApplyRecordVO> getAll() {
		return dao.getAll();
	}

	// public List<ApplyRecordVO> getAll(Map<String, String[]> map) {
	// return dao.getAll(map);
	// }
}
