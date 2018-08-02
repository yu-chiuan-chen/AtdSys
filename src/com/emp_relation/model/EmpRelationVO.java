package com.emp_relation.model;

import java.io.Serializable;

public class EmpRelationVO implements Serializable {
	private Integer emp_no;
	private Integer mgr_no;
	private Integer dir_mgr;
	public Integer getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}
	public Integer getMgr_no() {
		return mgr_no;
	}
	public void setMgr_no(Integer mgr_no) {
		this.mgr_no = mgr_no;
	}
	public Integer getDir_mgr() {
		return dir_mgr;
	}
	public void setDir_mgr(Integer dir_mgr) {
		this.dir_mgr = dir_mgr;
	}
}
