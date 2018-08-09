package common.vo;

import java.io.Serializable;
import java.util.Date;

import com.apply_type.model.ApplyTypeVO;
import com.employee.model.EmployeeVO;

public class ApplyRecordVO implements Serializable{
	private Integer ar_no;
	private Integer emp_no;
	private Integer at_no;
	private Date app_date;
	private Date sta_time;
	private Date end_time;
	private Integer review;
	private String  remarks;
	private String  reason;
	public Integer getAr_no() {
		return ar_no;
	}
	public void setAr_no(Integer ar_no) {
		this.ar_no = ar_no;
	}
	public Integer getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}
	public Integer getAt_no() {
		return at_no;
	}
	public void setAt_no(Integer at_no) {
		this.at_no = at_no;
	}
	public Date getApp_date() {
		return app_date;
	}
	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}
	public Date getSta_time() {
		return sta_time;
	}
	public void setSta_time(Date sta_time) {
		this.sta_time = sta_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
