package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.IChanceService;
import com.briup.service.IUserService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月1日 下午7:53:01 
* 类说明 
*/
@Controller
public class ChanceController {
	
	@Autowired
	private IUserService userservice;
	
	@Autowired
	private IChanceService service;
	@RequestMapping("toChance")
	public String toChance(HttpSession session,String customer,String address) {
		Page<Chance> chances = service.findChance(customer, address);
		//System.out.println(chances.getContent());
		List<User> Jinglis = userservice.findByJingli(4);
		session.setAttribute("Jinglis", Jinglis);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}

	@RequestMapping("saveChance")
	@ResponseBody
	public String saveChance(Chance chance) {
		service.saveChance(chance);
		return "保存成功";
	}
	
	@RequestMapping("chancePage")
	public String updatePage(Integer Index,HttpSession session,String customer,String address) {
		Page<Chance> chances = service.findChance(Index, customer, address);
		session.setAttribute("chances", chances);
		return "pages/sales";
		
	}
	
	@RequestMapping("deleteChance")
	@ResponseBody
	public String deleteChance(Integer id) {
		service.deleteChance(id);
		return "删除成功";
		
	}
	
	@RequestMapping("findChanceById")
	@ResponseBody
	public Chance findChanceById(Integer id) {
		Chance chance = service.findChanceById(id);
		return chance;
		
	}
	
	@RequestMapping("find")
	@ResponseBody
	public String find(HttpSession session,String address,String customer,Integer pageIndex) {
		System.out.println("customer: "+customer);
		System.out.println("address: "+address);
		Page<Chance> chances = service.findChance(customer, address);
		for (Chance chance : chances) {
			System.out.println("后台输出"+chance);
		}
		session.setAttribute("chances", chances);
		return "查询成功";
		
	}

}
