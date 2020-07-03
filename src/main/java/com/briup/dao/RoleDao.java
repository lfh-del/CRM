package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Role;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年3月27日 下午2:47:57 
* 类说明 
*/
public interface RoleDao extends JpaRepository<Role, Integer>{

}
