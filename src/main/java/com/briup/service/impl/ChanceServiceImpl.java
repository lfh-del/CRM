package com.briup.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.dao.ChanceDao;
import com.briup.service.IChanceService;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月1日 下午7:52:41 
* 类说明 
*/
@Service
public class ChanceServiceImpl implements IChanceService{
	@Autowired
	private ChanceDao dao;

	@Override
	public void saveChance(Chance chance) {
		dao.save(chance);
		
	}

	@Override
	public Page<Chance> findChance(String customer,String address) {
		
		return findChance(0,customer,address);
	}

	@Override
	public Page<Chance> findChance(Integer pageIndex,String customer,String address) {
		if((customer!=null && customer.trim()!="") && (address!=null && address.trim()!="")) {
			//根据顾客名字和地址查询
			return dao.findByCustomerAndAddress(customer,address, PageRequest.of(pageIndex, 3));
		}
		if(customer!=null && customer.trim()!="") {
			//根据顾客名字查询
			 Page<Chance> chanceList = dao.findByCustomerLike(customer, PageRequest.of(pageIndex, 3));
			return chanceList;
		}else if(address!=null && address.trim()!="") {
			//根据地址查询
			return dao.findByAddress(address, PageRequest.of(pageIndex, 3));
		}else {
			//根据无条件查询
			
			return dao.findAll(PageRequest.of(pageIndex, 3));
		}
	}

	@Override
	public void deleteChance(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Chance findChanceById(Integer id) {
		Chance chance = dao.getOne(id);
		return chance;
	}

	

}
