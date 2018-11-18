package common.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import common.vo.EmployeeVO;

public class ApplyTypeVO implements Serializable{
	private Integer at_no;
	private String name;
	private String remarks;
//	private Set<EmployeeVO> emps = new HashSet<EmployeeVO>();
	public Integer getAt_no() {
		return at_no;
	}
	public void setAt_no(Integer at_no) {
		this.at_no = at_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
//	public Set<EmployeeVO> getEmps() {
//		return emps;
//	}
//	public void setEmps(Set<EmployeeVO> emps) {
//		this.emps = emps;
//	}
	
}
