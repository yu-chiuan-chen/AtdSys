package common.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import common.vo.DepartmentVO;
import common.vo.PunchRecordVO;
import common.dao.EmployeeHibernateDAO;
import common.vo.ApplyRecordVO;
import common.utils.HibernateUtil;

public class ApplyRecordHibernateDAO implements ApplyRecordDAO_interface {

	private static final String GET_ALL_STMT = "from ApplyRecordVO order by Ar_no";
	private static final String GET_USER_RECORD = "from ApplyRecordVO where emp_no =";


	@Override
	public void insert(ApplyRecordVO ARVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ARVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ApplyRecordVO ARVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ARVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer Ar_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			// 【此時多方(宜)可採用HQL刪除】
			// Query query = session.createQuery("delete employee where
			// empno=?");
			// query.setParameter(0, empno);
			// System.out.println("刪除的筆數=" + query.executeUpdate());

			// 【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			ApplyRecordVO ARVO = new ApplyRecordVO();
			ARVO.setAr_no(Ar_no);
			session.delete(ARVO);

			// 【此時多方不可(不宜)採用cascade聯級刪除】
			// 【多方emp2.hbm.xml如果設為 cascade="all"或
			// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
			// ApplyRecordVO ARVO = (ApplyRecordVO) session.get(ApplyRecordVO.class,
			// empno);
			// session.delete(ARVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ApplyRecordVO findByPrimaryKey(Integer empno) {
		ApplyRecordVO ARVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ARVO = (ApplyRecordVO) session.get(ApplyRecordVO.class, empno);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ARVO;
	}

	@Override
	public List<ApplyRecordVO> getAll() {
		List<ApplyRecordVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	

	@Override
	public List<ApplyRecordVO> findListByPrimaryKey(Integer empno){
		List<ApplyRecordVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_USER_RECORD+empno);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
		
	}
	@Override
	public List<ApplyRecordVO> getAll(Map<String, String[]> map) {
		List<ApplyRecordVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {

		ApplyRecordHibernateDAO dao = new ApplyRecordHibernateDAO();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMdd HH:mm:ss.SSS");
//		
//		Calendar cc = Calendar.getInstance();
//		
//		
//		
//		try {
//			Date dd = sdf.parse("2001-03-16 111111");
//			
//			cc.setTime(dd);
//			cc.add(Calendar.DATE, -4);
//			cc.add(Calendar.HOUR, -4);
//			
//			System.out.println("sdf2= "+ sdf2.format(cc.getTime()));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		
//		// ● 新增
//		 ApplyRecordVO ARVO = new ApplyRecordVO();
//		 ARVO.setEmp_no(3);
//		 ARVO.setAt_no(2);
//		 try {
//			ARVO.setApp_date(sdf.parse("2001-01-15 111111"));
//			ARVO.setSta_time(sdf.parse("2001-03-15 111111"));
//			ARVO.setEnd_time(sdf.parse("2001-03-16 111111"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		 ARVO.setReview(0);
//		 ARVO.setRemarks("無");
//		 ARVO.setReason("有事");
//		 dao.insert(ARVO);

		// ● 修改
//		 ApplyRecordVO ARVO = new ApplyRecordVO();
//		 ARVO.setAr_no(2);
//		 ARVO.setEmp_no(2);
//		 ARVO.setAt_no(2);
//		 ARVO.setApp_date(java.sql.Date.valueOf("2001-01-15"));
//		 ARVO.setSta_time(java.sql.Date.valueOf("2001-03-15"));
//		 ARVO.setEnd_time(java.sql.Date.valueOf("2001-03-16"));
//		 ARVO.setReview(0);
//		 ARVO.setRemarks("修改");
//		 ARVO.setReason("有事");
//		 dao.insert(ARVO);

		// ● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
//		 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		 dao.delete(2);

		// ● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		 ApplyRecordVO ARVO = dao.findByPrimaryKey(5);
//			System.out.print(ARVO.getAr_no() + ",");
//			System.out.print(ARVO.getEmp_no() + ",");
//			System.out.print(ARVO.getAt_no() + ",");
//			System.out.print(ARVO.getApp_date() + ",");
//			System.out.print(ARVO.getSta_time() + ",");
//			System.out.print(ARVO.getEnd_time() + ",");
//			System.out.print(ARVO.getReview() + ",");
//			System.out.print(ARVO.getRemarks() + ",");
//			System.out.print(ARVO.getReason() + ",");
//			System.out.println();
//		 System.out.println("\n---------------------");

		// ● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		List<ApplyRecordVO> list = dao.findListByPrimaryKey(1);
//		for (ApplyRecordVO ARVO : list) {
//			System.out.print(ARVO.getAr_no() + ",");
//			System.out.print(ARVO.getEmp_no() + ",");
//			System.out.print(ARVO.getAt_no() + ",");
//			System.out.print(ARVO.getApp_date() + ",");
//			System.out.print(ARVO.getSta_time() + ",");
//			System.out.print(ARVO.getEnd_time() + ",");
//			System.out.print(ARVO.getReview() + ",");
//			System.out.print(ARVO.getRemarks() + ",");
//			System.out.print(ARVO.getReason() + ",");
//			System.out.println();
//		}
	}
}