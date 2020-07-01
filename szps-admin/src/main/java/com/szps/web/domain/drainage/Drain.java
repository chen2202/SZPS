package com.szps.web.domain.drainage;

/**
 * DRAINAGE_T_DRAIN表实体类
 * @author zxc
 *
 */
public class Drain {
	private int drain_id; //排水口id
	private int household_id; //对应的排水口id
	private String drain_type; //排水口类型
	private String pskwz; //排水口位置或排水井编码
	private String prszpsgw; //是否排入市政排水管网
	private String prxqgw; //排入新区管网
	private String hasonelinedevice; //有一个线路设备
	private String water_to; //排水去向
	private String water_name; //水体名称
	private String pretreatment_facility; //预处理设施列表
	private int pretreatment_facility_number; //对应的数量列表
	private String pretreatment_facility_note; //备注列表，逗号分隔
	private String otherAction; //其他处理方式
	private String other_note; //其他备注说明
	private String importBz; //如果批量导入记录临时表的名称
	private int pactionNum; //预处理设施数量
	private int pidx1;
	private int pidx2;
	private int pidx3;
	private int pidx4;
	private int pidx5;
	private int pidx6;
	private int pidx7;
	private int nidx1;
	private int nidx2;
	private int nidx3;
	private int nidx4;
	private int nidx5;
	private int nidx6;
	private int nidx7;
	private String pas;
	private String ns;
	private String riverName; //排水口对应的流域名称
	
	public int getDrain_id() {
		return drain_id;
	}
	public void setDrain_id(int drain_id) {
		this.drain_id = drain_id;
	}
	public int getHousehold_id() {
		return household_id;
	}
	public void setHousehold_id(int household_id) {
		this.household_id = household_id;
	}
	public String getDrain_type() {
		return drain_type;
	}
	public void setDrain_type(String drain_type) {
		this.drain_type = drain_type;
	}
	public String getPskwz() {
		return pskwz;
	}
	public void setPskwz(String pskwz) {
		this.pskwz = pskwz;
	}
	public String getPrszpsgw() {
		return prszpsgw;
	}
	public void setPrszpsgw(String prszpsgw) {
		this.prszpsgw = prszpsgw;
	}
	public String getPrxqgw() {
		return prxqgw;
	}
	public void setPrxqgw(String prxqgw) {
		this.prxqgw = prxqgw;
	}
	public String getHasonelinedevice() {
		return hasonelinedevice;
	}
	public void setHasonelinedevice(String hasonelinedevice) {
		this.hasonelinedevice = hasonelinedevice;
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
	public String getPretreatment_facility() {
		return pretreatment_facility;
	}
	public void setPretreatment_facility(String pretreatment_facility) {
		this.pretreatment_facility = pretreatment_facility;
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
	public String getOtherAction() {
		return otherAction;
	}
	public void setOtherAction(String otherAction) {
		this.otherAction = otherAction;
	}
	public String getOther_note() {
		return other_note;
	}
	public void setOther_note(String other_note) {
		this.other_note = other_note;
	}
	public String getImportBz() {
		return importBz;
	}
	public void setImportBz(String importBz) {
		this.importBz = importBz;
	}
	public int getPactionNum() {
		return pactionNum;
	}
	public void setPactionNum(int pactionNum) {
		this.pactionNum = pactionNum;
	}
	public int getPidx1() {
		return pidx1;
	}
	public void setPidx1(int pidx1) {
		this.pidx1 = pidx1;
	}
	public int getPidx2() {
		return pidx2;
	}
	public void setPidx2(int pidx2) {
		this.pidx2 = pidx2;
	}
	public int getPidx3() {
		return pidx3;
	}
	public void setPidx3(int pidx3) {
		this.pidx3 = pidx3;
	}
	public int getPidx4() {
		return pidx4;
	}
	public void setPidx4(int pidx4) {
		this.pidx4 = pidx4;
	}
	public int getPidx5() {
		return pidx5;
	}
	public void setPidx5(int pidx5) {
		this.pidx5 = pidx5;
	}
	public int getPidx6() {
		return pidx6;
	}
	public void setPidx6(int pidx6) {
		this.pidx6 = pidx6;
	}
	public int getPidx7() {
		return pidx7;
	}
	public void setPidx7(int pidx7) {
		this.pidx7 = pidx7;
	}
	public int getNidx1() {
		return nidx1;
	}
	public void setNidx1(int nidx1) {
		this.nidx1 = nidx1;
	}
	public int getNidx2() {
		return nidx2;
	}
	public void setNidx2(int nidx2) {
		this.nidx2 = nidx2;
	}
	public int getNidx3() {
		return nidx3;
	}
	public void setNidx3(int nidx3) {
		this.nidx3 = nidx3;
	}
	public int getNidx4() {
		return nidx4;
	}
	public void setNidx4(int nidx4) {
		this.nidx4 = nidx4;
	}
	public int getNidx5() {
		return nidx5;
	}
	public void setNidx5(int nidx5) {
		this.nidx5 = nidx5;
	}
	public int getNidx6() {
		return nidx6;
	}
	public void setNidx6(int nidx6) {
		this.nidx6 = nidx6;
	}
	public int getNidx7() {
		return nidx7;
	}
	public void setNidx7(int nidx7) {
		this.nidx7 = nidx7;
	}
	public String getPas() {
		return pas;
	}
	public void setPas(String pas) {
		this.pas = pas;
	}
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	public String getRiverName() {
		return riverName;
	}
	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}
}
