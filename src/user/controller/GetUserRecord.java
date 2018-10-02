package user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.service.*;
import common.vo.*;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserRecord extends ActionSupport{
	private Integer emp_no;
	private Integer type_no;
	private Map<String, Object> result;

	public Integer getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
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
	
	public String execute() {
		System.out.println("準備取員工： "+emp_no+" 號,狀態是 "+type_no);
		
		List<PunchRecordVO> listPRs=null;
		List<ApplyRecordVO> listARs=null;
		result=new HashMap<String,Object>();
		
		PunchRecordService PRService = new PunchRecordService();
		ApplyRecordService ARService = new ApplyRecordService();
		listPRs= PRService.getPRs(emp_no);
		listARs= ARService.getARs(emp_no);
		
		for (ApplyRecordVO PRVO:listARs){
			System.out.println(PRVO.getEmpVO().getName());
			System.out.println(PRVO.getSta_time());
			System.out.println(PRVO.getReason());
		}
		
		result.put("status", "success");
		result.put("listPRs", listPRs);
		result.put("listARs", listARs);
		return "json";

	}


}
