package user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import common.vo.PunchRecordVO;
import user.service.ApplyRecordService;
import user.service.PunchRecordService;

public class AddApplyRecordAction {
	private Integer emp_no;
	private String sta_time;
	private String end_time;
	private String reason;
	private Integer at_no;
	private Map<String, Object> result;

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

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String execute() {
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
		result = new HashMap<String, Object>();
		result.put("status", "success");
		return "json";

	}
}
