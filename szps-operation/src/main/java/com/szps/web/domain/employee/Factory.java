package com.szps.web.domain.employee;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.szps.common.annotation.Excel;

public class Factory {
	@Excel(name = "水厂编码")
	private String factory_id; //水质净化厂代码
	@Excel(name = "厂名")
	private String name; //水质净化厂名
	@Excel(name = "地址")
	private String address; //水厂地址
	@Excel(name = "归属区域")
	private String attribution_area; //归属区域
	@Excel(name = "厂长姓名")
	private String factory_director; //厂长
	@Excel(name = "副厂长姓名")
	private String deputy_director; //副厂长
	@Excel(name = "日处理水量 吨/天")
	private int daily_water; //日处理水量
	@Excel(name = "联系电话")
	private long telephone; //水厂电话
	@Excel(name = "简介")
	private String introduction; //简介
	
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("factory_id", getFactory_id())
            .append("name", getName())
            .append("address", getAddress())
            .append("attribution_area", getAttribution_area())
            .append("factory_director", getFactory_director())
            .append("deputy_director", getDeputy_director())
            .append("daily_water", getDaily_water())
            .append("telephone", getTelephone())
            .append("introduction", getIntroduction())
            .toString();
    }
	
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
