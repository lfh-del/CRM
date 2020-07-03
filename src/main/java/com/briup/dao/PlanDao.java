package com.briup.dao;
/** 
* @author 作者 lfh: 
* @version 创建时间：2020年6月10日 下午7:45:24 
* 类说明 
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Plan;

public interface PlanDao extends JpaRepository<Plan, Integer>{
	

}
