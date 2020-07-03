package com.briup.service;

import java.util.List;

import com.briup.bean.CustomerConstitute;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月3日 下午1:03:28 
* 类说明 
*/
public interface ICustomerConstituteService {
	//地区分类
	List<CustomerConstitute> regionAnalyze();
	//等级分类
	List<CustomerConstitute> levelAnalyze();
}
