package demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hibernate.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.log4j.Logger;

public class DemoAction extends ActionSupport 
	implements ModelDriven<DemoModel>, ServletRequestAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5627216896930359100L;
	private DemoModel model;
	private HttpServletRequest requset;
	private final static Logger log = Logger.getLogger("DemoLog");

	@Override
	public DemoModel getModel() {
		model = new DemoModel();
		return model;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.requset = request;
	}
	
	/* JSON 傳值 START */
	protected String JSON = "json";
	private Map<String, Object> jsonResult;
	public final Map<String, Object> getJsonResult() {
		return jsonResult;
	}
	public final void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}
	/* JSON 傳值 END */

	/* Spring接管Struts START */
	private DemoService demoSvc;
	
	public final DemoService getDemoSvc() {
		return demoSvc;
	}

	public final void setDemoSvc(DemoService demoSvc) {
		System.out.println("demoSvc is set!! "+ demoSvc);
		this.demoSvc = demoSvc;
	}
	private int count = 0;
	/* Spring接管Struts END */

	public String demo() {
		
		// 測試log4j
		log.info("Hello Struts 2, DemoAction.demo in!!"+ (++count));
		
		// 測試Spring接管Struts
		demoSvc.sayHelloToSS();
		// Spring接管後，不再需要自行getWebApplicationContext
		// 將Spring交由web容器初始化後，即以下方方式調用
		//WebApplicationContext wc = 
		//		WebApplicationContextUtils.getWebApplicationContext(requset.getServletContext());
		
		// Spring接管後，不再需要自行getBean
		// 以下同以往做法
		//SessionFactory sf = (SessionFactory) wc.getBean("sessionFactory");
		//Session ss = sf.openSession();
		
		//HibernateUtil hb = (HibernateUtil) wc.getBean("hbUtil");
		Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction ts = ss.beginTransaction();

//		TypedQuery<HibernateDemoVO> query = ss.createQuery(" SELECT friend_id FROM HibernateDemoVO WHERE mem_id = :mem_id ");
		TypedQuery<HibernateDemoVO> query = ss.createQuery("FROM DepartmentVO");
//		query.setParameter(0, 11000001);

		query.setParameter("mem_id", 11000001);
		List resultList = query.getResultList();
		Iterator iterator =  resultList.iterator();
		
		Integer demoStr = 0;
		
		while(iterator.hasNext()) {
			//HibernateDemoVO vo = (HibernateDemoVO) iterator.next();
		    System.out.println("friend_id="+ iterator.next());
		    demoStr = (Integer) iterator.next();
		}
		
		model.setMsg("Hello "+ demoStr);
		return SUCCESS;
	}
	
	/**
	 * JSON傳值測試
	 * @return
	 */
	public String testJson() {
		System.out.println("DemoAction.testJson in!!");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "Hello Struts2-Json");
		result.put("msg_null", null);
		setJsonResult(result);
		return JSON;
	}
}
