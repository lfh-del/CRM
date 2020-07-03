package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Plan;
import com.briup.dao.PlanDao;
import com.briup.service.IplanService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年6月10日 下午9:20:50 
* 类说明 
*/
@Service
public class PlanServiceImpl implements IplanService{

	@Autowired
	private PlanDao dao;
	@Override
	public Page<Plan> findPlans(String address) {

		return dao.findAll(PageRequest.of(0, 10));
	}
}
