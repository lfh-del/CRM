package com.briup.service;
/** 
* @author 作者 lfh: 
* @version 创建时间：2020年6月10日 下午9:20:31 
* 类说明 
*/

import org.springframework.data.domain.Page;

import com.briup.bean.Plan;

public interface IplanService {
	Page<Plan> findPlans(String address);
}
