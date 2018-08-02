package com.department.model;

	import java.util.*;
	import com.employee.model.EmployeeVO;

	public class DepartmentVO   implements java.io.Serializable{
	
		private Integer dep_no;
		private String name;
		private String remarks;
		private Set<EmployeeVO> emps = new HashSet<EmployeeVO>();
		public Integer getDep_no() {
			return dep_no;
		}
		public void setDep_no(Integer dep_no) {
			this.dep_no = dep_no;
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
		public Set<EmployeeVO> getEmps() {
			return emps;
		}
		public void setEmps(Set<EmployeeVO> emps) {
			this.emps = emps;
		}

		
	
}
