package com.szps.web.domain.employee;

public class Factory {
	private String factory_id; //水质净化厂代码
	private String name; //水质净化厂名
	private String address; //水厂地址
	private String attribution_area; //归属区域
	private String factory_director; //厂长
	private String deputy_director; //副厂长
	private int daily_water; //日处理水量
	private long telephone; //水厂电话
	private String introduction; //简介
	public String getFactory_id() {
		return factory_id;
	}
	public void setFactory_id(String factory_id) {
		this.factory_id = factory_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAttribution_area() {
		return attribution_area;
	}
	public void setAttribution_area(String attribution_area) {
		this.attribution_area = attribution_area;
	}
	public String getFactory_director() {
		return factory_director;
	}
	public void setFactory_director(String factory_director) {
		this.factory_director = factory_director;
	}
	public String getDeputy_director() {
		return deputy_director;
	}
	public void setDeputy_director(String deputy_director) {
		this.deputy_director = deputy_director;
	}
	public int getDaily_water() {
		return daily_water;
	}
	public void setDaily_water(int daily_water) {
		this.daily_water = daily_water;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
