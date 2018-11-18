package common.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import common.vo.DepartmentVO;

public class EmployeeVO implements java.io.Serializable {

	private Integer emp_no;
	private String name;
	private String title;
	private Date fir_day;
	private Date las_day;
	private Date birthday;
	private byte[] photo;
	private String email;
	private String psw;
	private String is_mgr;
	private String remarks;
	private DepartmentVO depVO;
	private Set<PunchRecordVO> punchRecords = new HashSet<PunchRecordVO>();
	private Set<ApplyRecordVO> applyRecords = new HashSet<ApplyRecordVO>();
	
	public Integer getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFir_day() {
		return fir_day;
	}

	public void setFir_day(Date fir_day) {
		this.fir_day = fir_day;
	}

	public Date getLas_day() {
		return las_day;
	}

	public void setLas_day(Date las_day) {
		this.las_day = las_day;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getIs_mgr() {
		return is_mgr;
	}

	public void setIs_mgr(String is_mgr) {
		this.is_mgr = is_mgr;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public DepartmentVO getDepVO() {
		return depVO;
	}

	public void setDepVO(DepartmentVO depVO) {
		this.depVO = depVO;
	}

	public Set<PunchRecordVO> getPunchRecords() {
		return punchRecords;
	}

	public void setPunchRecords(Set<PunchRecordVO> punchRecords) {
		this.punchRecords = punchRecords;
	}

	public Set<ApplyRecordVO> getApplyRecords() {
		return applyRecords;
	}

	public void setApplyRecords(Set<ApplyRecordVO> applyRecords) {
		this.applyRecords = applyRecords;
	}
}
