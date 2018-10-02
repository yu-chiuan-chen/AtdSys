package user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport{
	private Map<String,String> result;
	
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	public String execute() {
		result = new HashMap<String, String>();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.clear();
		result.put("status", "success");
		return "json";
	
	}
}


  
  
