package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月26日 下午4:33:27 
* 类说明 
*/
@Controller
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IRoleService roleService;
	
	//获取前台输入的用户名密码，进行验证
	@RequestMapping("user/login")
//	@PostMapping("/user/login")
//	@GetMapping("/user/loign")
	@ResponseBody
	public String login(String name,String password,HttpSession session) {
		//需要判断用户名是否为空,前台已经完成
		
		//调用service层，判断用户名和密码是否正确
		User user = service.findByName(name);
		session.setAttribute("user", user);
		//如果user为空，则表示用户名不存在
		if(user==null) {
			return "当前用户不存在！";
		}
		
		//判断密码是否正确
		if(!user.getPassword().equals(password)) {
			return "密码错误";
		}
		//判断用户状态，1为正常，2为注销
		if(user.getFlag()!=1) {
			return "该用户已被注销！";
		}
		
		return "success"; //success.html
	}
	
	//退出功能
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	
	//显示用户管理的界面
	@RequestMapping("toUser")
	
	public String toUser(HttpSession session,Integer roleId) {
	session.setAttribute("roleId", roleId);
		
		//查询用户信息
		Page<User> users = service.findUsersByRole(roleId);
		session.setAttribute("users", users);
	   //查询角色信息
		List<Role> allRoles = roleService.allRoles();
		session.setAttribute("allRoles", allRoles);
		return  "pages/user";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveUser(User user) {
		service.saveUser(user);
		return "保存成功";
	}
	

	@RequestMapping("udateUser")
	@ResponseBody
	public String updateUser(User user) {
		service.saveUser(user);
		return "修改成功";
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(Integer id)
	{
		service.deleteUserById(id);
		return "删除成功";
	}
	
	@RequestMapping("finduserById")
	@ResponseBody
	public User updateUser(Integer id)
	{
		User user = service.finduserById(id);
		return user;
	}
	
	 @RequestMapping("pageUser")
	 public String updatepageRole(Integer pageIndex,HttpSession session) {
		 Integer roleId = (Integer) session.getAttribute("roleId");
			Page<User> users = service.findUsersByRole(roleId, pageIndex);
			session.setAttribute("users", users);
			return "pages/user";
	 }
	
		//重置
		@RequestMapping("resetUser")
		@ResponseBody
		public String resetUser(HttpSession session) {
			session.removeAttribute("roleId");
			return "重置成功";
		}
}
