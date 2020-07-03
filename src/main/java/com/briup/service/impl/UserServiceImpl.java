package com.briup.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月26日 下午4:51:28 
* 类说明  和user用户相关的service层逻辑
*/

@Service
public class UserServiceImpl implements IUserService{
	//dao层
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
		
	}

	@Override
	public User finduserById(Integer id) {
		User user = userDao.getOne(id);
		return user;
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId) {
		return findUsersByRole(roleId, 0);
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId, Integer pageIndex) {
		Page<User> users = null;
		if (roleId == null) {
			//将所有用户查询出来
			users = userDao.findAll(PageRequest.of(pageIndex, 3));
		} else {
			//根据角色条件筛选用户
			Role role = new Role();
			role.setId(roleId);
			users = userDao.findByRole(role, PageRequest.of(pageIndex, 3));
		}
		return users;
	}

	@Override
	public List<User> findByJingli(Integer id) {
		List<User> users = userDao.findByRoleId(id);
		return users;
	}

}
