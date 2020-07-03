package com.briup.service;
/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月26日 下午4:48:02 
* 类说明 
*/

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;
import com.briup.bean.User;

public interface IUserService {

	public User findByName(String name);
	
	public void saveUser(User user);
	
	public void deleteUserById(Integer id);
	
	public User  finduserById(Integer id);
	
	   //查询User信息
	Page<User> findUsersByRole(Integer roleId);
		//根据分页查询User的相关信息
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	
	List<User> findByJingli(Integer id);
}
