package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;


/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月1日 下午7:52:23 
* 类说明 
*/
public interface IChanceService {
	   //保存chance
	   void saveChance(Chance chance);
	
	   //查询chance信息
		Page<Chance> findChance(String customer,String address);
		//根据分页查询chance的相关信息
		Page<Chance> findChance(Integer pageIndex,String customer,String address);
		
		//删除
		void deleteChance(Integer id);
		//修改
		Chance findChanceById(Integer id);
		
		
		
		

}
