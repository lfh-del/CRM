package com.briup.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;
/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月27日 上午11:51:50 
* 类说明 :
* 角色管理模块
*/
@Controller
public class RoleController {
	@Autowired
	private IRoleService serviece;
	
	 @RequestMapping("toRole")
		public  String toRole(HttpSession session) {
		 //将数据库中所有的角色信息查询出来，保存到session
		 Page<Role> roles = serviece.findAllRoles();
		 session.setAttribute("roles", roles);
			return "pages/role";
		}
	 
	 @RequestMapping("saveRole")
	 @ResponseBody
		public  String saveRole(Role role) {
		 serviece.saveRole(role);
		System.out.println("添加"+role);
			return "添加成功";
		}
	 
	 @RequestMapping("deleteRole")
	 @ResponseBody
		public  String deleteRole(Integer id) {
		 serviece.deleteRole(id);
			return "删除成功";
		}
	 @RequestMapping("updateRole")
	 @ResponseBody
		public String updateRole(Role role) {
		 serviece.saveRole(role);
		 System.out.println("修改"+role);
			return "修改成功";
		}  
	 @RequestMapping("findById")
	 @ResponseBody
		public Role findRole(Integer id) {
		Role role2 = serviece.findRoleById(id);
			return role2;
		}  
	 
	 @RequestMapping("pageRole")
	 public String updatepageRole(Integer pageIndex,HttpSession session) {
		 Page<Role> roles = serviece.findAllRoles(pageIndex);
		 session.setAttribute("roles", roles);
		 return "pages/role";
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
