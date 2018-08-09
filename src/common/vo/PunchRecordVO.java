package common.vo;

import java.util.Date;

import common.vo.ApplyTypeVO;
import common.vo.EmployeeVO;

public class PunchRecordVO {
	private Integer pr_no;
	private Date pr_time;
	private String remarks;
	private EmployeeVO empVO ;
	private ApplyTypeVO ATVO ;
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
	public ApplyTypeVO getATVO() {
		return ATVO;
	}
	public void setATVO(ApplyTypeVO aTVO) {
		ATVO = aTVO;
	}

}
