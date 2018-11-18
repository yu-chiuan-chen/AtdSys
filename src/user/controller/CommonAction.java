package user.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import common.utils.MD5Util;
import common.vo.EmployeeVO;
import user.service.EmployeeService;

public class CommonAction extends ActionSupport{

	private static final long serialVersionUID = 4856819956583979205L;

	private Integer emp_no;
	private String psw;
	private String name;
	Map<String, String> model;

	public Integer getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getModel() {
		return model;
	}

	public void setModel(Map<String, String> model) {
		this.model = model;
	}
	
	
	
	/**
	 * 
	 */
	public String login() {
		System.out.println("新新新新新新新新新新新新新新新新新新新");
		model = new HashMap<String, String>();
		System.out.println("dasds in!!!");
		EmployeeService empService = new EmployeeService();
		System.out.println(emp_no);
		EmployeeVO empVO = empService.getOneEmp(emp_no);
		System.out.println(empVO);
		String resultPsw = empVO.getPsw();
		this.name = empVO.getName();
		psw = MD5Util.encrypt(psw);
		System.out.println("emp_no：" + emp_no);
		System.out.println("輸入：" + psw);
		System.out.println("資料庫：" + resultPsw);
		if (resultPsw.equals(psw)) {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("userVO", empVO);

			model.put("status", "success");
			return "json";
		} else {
			model.put("status", "fail");
			return "json";
		}
	}
	
	
	
	/**
	 * 
	 */
	public String init() {
		
		System.out.println("in!!!");
		
		return SUCCESS;
	}
	
}
