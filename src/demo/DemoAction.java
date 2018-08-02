package demo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//@AllowedMethods("test")
public class DemoAction extends ActionSupport implements ModelDriven<DemoModel>{
	
	private DemoModel model;
	
	@Override
	public DemoModel getModel() {
		model = new DemoModel();
		return model;
	}
	
	public String demo() {
		System.out.println("Hello Struts 2, DemoAction in!!");
		model.setMsg("Hello Struts 2");
		return SUCCESS;
	}
	
}
