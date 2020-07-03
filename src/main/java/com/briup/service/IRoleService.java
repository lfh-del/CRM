package com.briup.service;
/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月27日 下午2:35:20 
* 类说明 
*/

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;

public interface IRoleService {
	//查询刚进入角色的第一页
	Page<Role> findAllRoles();
	
	//查询指定页面上的数据信息
	Page<Role> findAllRoles(Integer pageIndex);

	
	//新增和修改
	void saveRole(Role role);
	
	//通过id查
	Role  findRoleById(Integer id);

	
	//删除
	void deleteRole(Integer id);
	
	List<Role> allRoles();
}
