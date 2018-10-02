package user.controller;

import java.util.HashMap;
import java.util.Map;

import user.service.EmployeeService;
import common.vo.EmployeeVO;
import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import common.utils.MD5Util;

// 註1: 如果 Action 類別是一個 POJO , 那程式中的 execute() method 是必要元素
// 註2: 如果 implements Action 介面 , 則須實作其 public String execute() 抽象方法
// 註3: 如果 extends ActionSupport ,  則可省去其 public String execute() 方法
public class LoginAction extends ActionSupport {
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

	// 註1: execute() method 要回傳一個 String，這個 String 是要告知 Struts2 在執行完 Action
	// 之後，所要導向的頁面
	// 註2: 如果我們在 Action 的 execute() method 中回傳一個 "success" 的字串，Struts 2 就會到
	// struts.xml 中 的
	// action 之下找尋是否有符合的 <result name="success"> 可以對應
	// 註3: 我們可以在 Action 中所提供的 execute() method 裡加入我們的 business logic
	public String execute() {
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
}
