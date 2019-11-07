package com.szps.web.domain.drainage;

/**
 * DRAINAGE_T_DRAIN表实体类
 * @author zxc
 *
 */
public class Drain {
	private String household_id; //排水户编号
	private String drain_type; //排水口类型
	private String drain_id; //排水口编码/位置
	private String pretreatment_facility; //预处理设施列表
	private String other_pretreatment_facility; //其他预处理设施
	private int pretreatment_facility_number; //预处理设施数量
	private String pretreatment_facility_note; //预处理设施相关备注
	private String monitoring_facility; //是否安装监测设备
	private String water_to; //排水去向
	private String water_name; //水体名称
	private String other_note; //其他备注
	
	public String getHousehold_id() {
		return household_id;
	}
	public void setHousehold_id(String household_id) {
		this.household_id = household_id;
	}
	public String getDrain_type() {
		return drain_type;
	}
	public void setDrain_type(String drain_type) {
		this.drain_type = drain_type;
	}
	public String getDrain_id() {
		return drain_id;
	}
	public void setDrain_id(String drain_id) {
		this.drain_id = drain_id;
	}
	public String getPretreatment_facility() {
		return pretreatment_facility;
	}
	public void setPretreatment_facility(String pretreatment_facility) {
		this.pretreatment_facility = pretreatment_facility;
	}
	public String getOther_pretreatment_facility() {
		return other_pretreatment_facility;
	}
	public void setOther_pretreatment_facility(String other_pretreatment_facility) {
		this.other_pretreatment_facility = other_pretreatment_facility;
	}
	public int getPretreatment_facility_number() {
		return pretreatment_facility_number;
	}
	public void setPretreatment_facility_number(int pretreatment_facility_number) {
		this.pretreatment_facility_number = pretreatment_facility_number;
	}
	public String getPretreatment_facility_note() {
		return pretreatment_facility_note;
	}
	public void setPretreatment_facility_note(String pretreatment_facility_note) {
		this.pretreatment_facility_note = pretreatment_facility_note;
	}
	public String getMonitoring_facility() {
		return monitoring_facility;
	}
	public void setMonitoring_facility(String monitoring_facility) {
		this.monitoring_facility = monitoring_facility;
	}
	public String getWater_to() {
		return water_to;
	}
	public void setWater_to(String water_to) {
		this.water_to = water_to;
	}
	public String getWater_name() {
		return water_name;
	}
	public void setWater_name(String water_name) {
		this.water_name = water_name;
	}
	public String getOther_note() {
		return other_note;
	}
	public void setOther_note(String other_note) {
		this.other_note = other_note;
	}
}
