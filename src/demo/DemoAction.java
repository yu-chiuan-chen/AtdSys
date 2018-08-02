package demo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//@AllowedMethods("test")
public class DemoAction extends ActionSupport 
	implements ModelDriven<DemoModel>, ServletRequestAware{
	
	private DemoModel model;
	private HttpServletRequest requset;
	
	@Override
	public DemoModel getModel() {
		model = new DemoModel();
		return model;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.requset = request;
	}
	
	public String demo() {
		System.out.println("Hello Struts 2, DemoAction in!!");
		
		// 將Spring交由web容器初始化後，即以下方方式調用
		WebApplicationContext wc = 
				WebApplicationContextUtils.getWebApplicationContext(requset.getServletContext());
		
		// 以下同以往做法
		SessionFactory sf = (SessionFactory) wc.getBean("sessionFactory");
		Session ss = sf.openSession();
		Transaction ts = ss.beginTransaction();
		TypedQuery<HibernateDemoVO> query = ss.createQuery(" SELECT friend_id FROM HibernateDemoVO WHERE mem_id = :mem_id ");
//		query.setParameter(0, 11000001);
		query.setParameter("mem_id", 11000001);
		List resultList = query.getResultList();
		Iterator iterator =  resultList.iterator();
		
		Integer demoStr = 0;
		
		while(iterator.hasNext()) {
//			HibernateDemoVO vo = (HibernateDemoVO) iterator.next();
		    System.out.println("friend_id="+ iterator.next());
		    demoStr = (Integer) iterator.next();
		}
		
		model.setMsg("Hello "+ demoStr);
		return SUCCESS;
	}
	
}
