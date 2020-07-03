package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月1日 下午7:50:36 
* 类说明 
*/
public interface ChanceDao extends JpaRepository<Chance, Integer>{
	//根据顾客查询销售商机
	Page<Chance> findByCustomerLike(String customer,Pageable pageable);
	//根据地址顾客查询销售商机
	Page<Chance> findByAddress(String address,Pageable pageable);
	//根据客户经理，查询对应的销售商机并分页
	Page<Chance> findByHandler(User handler,Pageable pageable);
	//根据客户经理和地区，查询对应的销售商机并分页
	Page<Chance> findByHandlerAndAddress(String address,User handler,Pageable pageable);
	//根据客户经理和地区，查询对应的销售商机并分页
	Page<Chance> findByCustomerAndAddress(String address,String customer,Pageable pageable);
}
