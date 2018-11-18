package user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.vo.ApplyRecordVO;
import common.vo.ApplyTypeVO;
import common.vo.EmployeeVO;
import common.vo.PunchRecordVO;
import user.service.ApplyRecordService;
import user.service.ApplyTypeService;
import user.service.EmployeeService;
import user.service.PunchRecordService;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 4856819956583979205L;

	private Integer emp_no;
	private Integer type_no;
	private String sta_time;
	private String end_time;
	private String reason;
	private Integer at_no;
	
	private Map<String, Object> result;
	private Map<String, Object> logoutmap;
	private Map<String, Object> ondutymap;
	private Map<String, Object> offdutymap;
	private Map<String, Object> recordmap;
	private Map<String, Object> typemap;
	private Map<String, Object> addapplymap;


	public Integer getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}

	public String getSta_time() {
		return sta_time;
	}

	public void setSta_time(String sta_time) {
		this.sta_time = sta_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getAt_no() {
		return at_no;
	}

	public void setAt_no(Integer at_no) {
		this.at_no = at_no;
	}

	public Integer getType_no() {
		return type_no;
	}

	public void setType_no(Integer type_no) {
		this.type_no = type_no;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Map<String, Object> getLogoutmap() {
		return logoutmap;
	}

	public void setLogoutmap(Map<String, Object> logoutmap) {
		this.logoutmap = logoutmap;
	}

	public Map<String, Object> getOndutymap() {
		return ondutymap;
	}

	public void setOndutymap(Map<String, Object> ondutymap) {
		this.ondutymap = ondutymap;
	}

	public Map<String, Object> getOffdutymap() {
		return offdutymap;
	}

	public void setOffdutymap(Map<String, Object> offdutymap) {
		this.offdutymap = offdutymap;
	}

	public Map<String, Object> getRecordmap() {
		return recordmap;
	}

	public void setRecordmap(Map<String, Object> recordmap) {
		this.recordmap = recordmap;
	}

	public Map<String, Object> getTypemap() {
		return typemap;
	}

	public void setTypemap(Map<String, Object> typemap) {
		this.typemap = typemap;
	}

	public Map<String, Object> getAddapplymap() {
		return addapplymap;
	}

	public void setAddapplymap(Map<String, Object> addapplymap) {
		this.addapplymap = addapplymap;
	}

	public String init() {

		System.out.println("歡迎in!!!");

		return LOGIN;
	}

	public String LogOut() {

		logoutmap = new HashMap<String, Object>();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.clear();
		logoutmap.put("status", "success");

		return "LogOut";
	}

	public String onDuty() {

		System.out.println("準備打卡" + emp_no);
		ondutymap = new HashMap<String, Object>();
		EmployeeService empService = new EmployeeService();
		PunchRecordService PRService = new PunchRecordService();
		EmployeeVO empVO = empService.getOneEmp(emp_no);
		System.out.println(empVO.getName());
		PRService.addPR(empVO, 1, new Date(), null);

		ondutymap.put("status", "success");

		return "onDuty";
	}

	public String offDuty() {

		System.out.println("準備下班" + emp_no);
		offdutymap = new HashMap<String, Object>();
		EmployeeService empService = new EmployeeService();
		PunchRecordService PRService = new PunchRecordService();
		EmployeeVO empVO = empService.getOneEmp(emp_no);
		System.out.println(empVO.getName());
		PRService.addPR(empVO, 2, new Date(), null);

		offdutymap.put("status", "success");

		return "offDuty";

	}

	public String getUserRecordAction() {
		System.out.println("準備取員工： " + emp_no + " 號,狀態是 " + type_no);

		List<PunchRecordVO> listPRs = null;
		List<ApplyRecordVO> listARs = null;
		recordmap = new HashMap<String, Object>();

		PunchRecordService PRService = new PunchRecordService();
		ApplyRecordService ARService = new ApplyRecordService();
		listPRs = PRService.getPRs(emp_no);
		listARs = ARService.getARs(emp_no);

		for (ApplyRecordVO PRVO : listARs) {
			System.out.println(PRVO.getEmpVO().getName());
			System.out.println(PRVO.getSta_time());
			System.out.println(PRVO.getReason());
		}

		recordmap.put("status", "success");
		recordmap.put("listPRs", listPRs);
		recordmap.put("listARs", listARs);

		return "getUserRecordAction";

	}

	public String getApplyType() {
		System.out.println("取請假類別清單");
		ApplyTypeService ATservice = new ApplyTypeService();
		List<ApplyTypeVO> listAT = ATservice.getAll();

		typemap = new HashMap<String, Object>();
		typemap.put("status", "success");
		typemap.put("listAT", listAT);

		return "getApplyType";

	}
	
	public String addapplyRecord() {
		System.out.println("準備申請紀錄： " + emp_no + "   " + "    sta_time:" + sta_time + "    end_time:" +  end_time + "    reason:"
				+ reason + "    at_no:" + at_no);
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = null;
		Date end = null;
		try {
			start =s.parse(sta_time) ;
			end =s.parse(end_time) ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ApplyRecordService ARservice = new ApplyRecordService();
		ARservice.addAR(emp_no, at_no, new Date(), start, end,0, null, reason);
		addapplymap = new HashMap<String, Object>();
		addapplymap.put("status", "success");
		return "addapplyRecord";

	}

}
