package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.vo.ApplyTypeVO;
import user.service.ApplyTypeService;

public class GetApplyTypeAction {
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String execute() {
		System.out.println("取請假類別清單");
		ApplyTypeService ATservice = new ApplyTypeService();
		List<ApplyTypeVO> listAT=ATservice.getAll();
		
		result = new HashMap<String, Object>();
		result.put("status", "success");
		result.put("listAT", listAT);
		return "json";

	}
}
