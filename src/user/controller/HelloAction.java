package user.controller;

//import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionSupport;

// 註1: 如果 Action 類別是一個 POJO , 那程式中的 execute() method 是必要元素
// 註2: 如果 implements Action 介面 , 則須實作其 public String execute() 抽象方法
// 註3: 如果 extends ActionSupport ,  則可省去其 public String execute() 方法
public class HelloAction { 
	private String ename = "World";

	public String getEname() {
		System.out.println("3. get 方法被 view 的 EL 或 OGNL取值時自動呼叫....................................................");
		return ename;
	}

	public void setEname(String ename) {
		System.out.println("1. set 方法被 Struts 2 自動呼叫.....................................................");
		this.ename = ename;
	}

	//註1:  execute() method 要回傳一個 String，這個 String 是要告知 Struts2 在執行完 Action 之後，所要導向的頁面
	//註2:  如果我們在 Action 的 execute() method 中回傳一個 "success" 的字串，Struts 2 就會到 struts.xml 中 的 
	//          action 之下找尋是否有符合的 <result name="success"> 可以對應
	//註3:  我們可以在 Action 中所提供的 execute() method 裡加入我們的 business logic
	public String execute() {
		System.out.println("2. execute 方法被 Struts 2 自動呼叫.....................................................");
		return "success";
	}
}
