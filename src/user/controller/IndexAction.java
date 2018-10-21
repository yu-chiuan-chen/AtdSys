package user.controller;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4856819956583979205L;

	public String init() {
		
		System.out.println("歡迎in!!!");
		
		return SUCCESS;
	}
	
}
