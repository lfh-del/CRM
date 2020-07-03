package com.briup.bean;

import javax.persistence.Entity;

/** 
* @author 作者 lfh: 
* @version 创建时间：2020年4月3日 上午10:37:03 
* 类说明 
*/
public class CustomerConstitute {

	private String name;
	private Float y;
	String drilldown;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
	}
	public String getDrilldown() {
		return drilldown;
	}
	public void setDrilldown(String drilldown) {
		this.drilldown = drilldown;
	}
	@Override
	public String toString() {
		return "customerConstitute [name=" + name + ", y=" + y + ", drilldown=" + drilldown + "]";
	}
	public CustomerConstitute(String name, Float y, String drilldown) {
		super();
		this.name = name;
		this.y = y;
		this.drilldown = drilldown;
	}
	public CustomerConstitute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
