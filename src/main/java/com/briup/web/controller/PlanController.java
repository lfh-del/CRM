package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Plan;
import com.briup.service.IplanService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年6月10日 下午9:21:15 
* 类说明 
*/
@Controller
public class PlanController {
	@Autowired
	private IplanService service;
	@RequestMapping("toPlan")
	public String toPlan(HttpSession session,String address) {
		Page<Plan> plans = service.findPlans(address);
		for (Plan plan : plans) {
			System.out.println("-----------"+plan);
		}
		session.setAttribute("plans", plans);
		return "pages/plan";
	
	}

}
