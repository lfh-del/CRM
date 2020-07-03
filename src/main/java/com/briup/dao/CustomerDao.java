package com.briup.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;
import com.briup.bean.CustomerConstitute;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月3日 上午10:48:32 
* 类说明 
*/
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	
	//数据分析相关内容
	List<Customer> findByRegion(String region);
	List<Customer> findByLevel(String region);

}
