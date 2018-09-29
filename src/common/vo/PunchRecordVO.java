package common.vo;

import java.io.Serializable;
import java.util.Date;

import common.vo.ApplyTypeVO;
import common.vo.EmployeeVO;


public class PunchRecordVO implements Serializable{
	private Integer pr_no;
	private Date pr_time;
	private Integer type_no;
	private String remarks;
	private EmployeeVO empVO ;
	public Integer getPr_no() {
		return pr_no;
	}
	public void setPr_no(Integer pr_no) {
		this.pr_no = pr_no;
	}
	public Date getPr_time() {
		return pr_time;
	}
	public void setPr_time(Date pr_time) {
		this.pr_time = pr_time;
	}
	public Integer getType_no() {
		return type_no;
	}
	public void setType_no(Integer type_no) {
		this.type_no = type_no;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public EmployeeVO getEmpVO() {
		return empVO;
	}
	public void setEmpVO(EmployeeVO empVO) {
		this.empVO = empVO;
	}
	
}
