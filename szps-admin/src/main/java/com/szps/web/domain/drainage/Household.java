package com.szps.web.domain.drainage;

import com.szps.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DRAINAGE_T_HOUSEHOLD表实体类
 * @author zxc
 *
 */
public class Household {
	@Excel(name = "编号")
	private int household_id; //排水户编号
	@Excel(name = "名称")
	private String household_name; //排水户名称
	@Excel(name = "记录状态")
	private String record_state; //记录状态
	@Excel(name = "门牌详细地址")
	private String doorplate_detail_address; //门牌详细地址
	@Excel(name = "经度")
	private double longitude; //经度
	@Excel(name = "纬度")
	private double latitude; //纬度
	@Excel(name = "行政区名")
	private String administrative_name; //行政区名
	@Excel(name = "街道名")
	private String street_name; //街道名
	@Excel(name = "居委会")
	private String committees;  //居委会
	@Excel(name = "街路巷名")
	private String lane_name; //街路巷名
	@Excel(name = "门牌号码")
	private String doorplate_number; //门牌号码
	@Excel(name = "排水户级别")
	private String household_level; //排水户级别
	@Excel(name = "上级排水户")
	private String parent_household_name; //上级排水户
	@Excel(name = "联系人")
	private String linkman; //联系人
	@Excel(name = "联系电话")
	private long telephone; //联系电话
	@Excel(name = "占地面积 /㎡")
	private double cover_area; //占地面积 /㎡
	@Excel(name = "水表编号")
	private String water_meter_id; //水表编号
	@Excel(name = "污水类别")
	private String sewage_category; //污水类别
	@Excel(name = "单位类型")
	private String unit_type; //单位类型(排水户类型)
	@Excel(name = "其他单位类型")
	private String other_unit_type; //其他单位类型（排水户类型）
	@Excel(name = "成分列表")
	private String cflist; //成分列表
	@Excel(name = "其他成分")
	private String other_composition; //其他成分
	@Excel(name = "内部废、污、雨是否分流")
	private String water_diversion; //内部废、污、雨是否分流
	@Excel(name = "是否取得营业执照")
	private String business_license; //是否取得营业执照
	@Excel(name = "统一社会信用代码")
	private String social_credit_id; //统一社会信用代码
	@Excel(name = "是否取得排水许可证")
	private String drainage_license; //是否取得排水许可证
	@Excel(name = "排水许可证号")
	private String drainage_license_number; //排水许可证号
	@Excel(name = "排水许可证开始日期")
	private String drainage_license_begin_time; //排水许可证开始日期
	@Excel(name = "排水许可证结束日期")
	private String drainage_license_end_time; //排水许可证结束日期
	@Excel(name = "是否取得排污许可证")
	private String sewage_license; //是否取得排污许可证
	@Excel(name = "排污许可证号")
	private String sewage_license_number; //排污许可证号
	@Excel(name = "排污许可证开始日期")
	private String sewage_license_begin_time; //排污许可证开始日期
	@Excel(name = "排污许可证结束日期")
	private String sewage_license_end_time; //排污许可证结束日期
	@Excel(name = "备注")
	private String note; //备注
	@Excel(name = "登记时间")
	private String registration_time; //登记时间
	@Excel(name = "登记人")
	private int registration_person; //登记人
	@Excel(name = "最新修改时间")
	private String update_time; //最新修改时间
	@Excel(name = "上一修改人")
	private String update_person; //上一修改人
	@Excel(name = "上级排水户ID")
	private int parent_household_id; //上级排水户ID
	@Excel(name = "地址补充信息")
	private String addressbz; //地址补充信息
	@Excel(name = "大类分类ID")
	private int maintypeidx; //大类分类ID
	@Excel(name = "是否取得餐饮许可证")
	private String hascycert; //是否取得餐饮许可证
	@Excel(name = "餐饮许可证号")
	private String cycertno; //餐饮许可证号
	@Excel(name = "餐饮许可证开始日期")
	private String cydate1; //餐饮许可证开始日期
	@Excel(name = "餐饮许可证结束日期")
	private String cydate2; //餐饮许可证结束日期
	@Excel(name = "排水口数量")
	private int psknum ; //排水口数量
	@Excel(name = "雨水排放口数量")
	private int yspsknum; //
	@Excel(name = "污水排放口数量")
	private int wspsknum; //
	@Excel(name = "混合排水口数量")
	private int hhpsknum; //
	@Excel(name = "初始登记人姓名")
	private String recorder; //
	@Excel(name = "排水户等级代号")
	private String levelchar; //
	@Excel(name = "是否曾经审核通过")
	private int hassh; //
	@Excel(name = "是否需办营业执照")
	private String needzz; //
	@Excel(name = "是否需办排水许可证")
	private String needpscert; //
	@Excel(name = "是否需办排污许可证")
	private String needpwcert; //
	@Excel(name = "是否需办餐饮许可证")
	private String needcycert; //
	@Excel(name = "导入临时表名称")
	private String importbz; //
	@Excel(name = "小区或附近建筑物")
	private String building; //
	@Excel(name = "是否有管网设施")
	private String hasdevice; //
	
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("household_id", getHousehold_id())
            .append("household_name", getHousehold_name())
            .append("record_state", getRecord_state())
            .append("doorplate_detail_address", getDoorplate_detail_address())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("administrative_name", getAdministrative_name())
            .append("street_name", getStreet_name())
            .append("committees", getCommittees())
            .append("lane_name", getLane_name())
            .append("doorplate_number", getDoorplate_number())
            .append("household_level", getHousehold_level())
            .append("parent_household_name", getParent_household_name())
            .append("linkman", getLinkman())
            .append("telephone", getTelephone())
            .append("cover_area", getCover_area())
            .append("water_meter_id", getWater_meter_id())
            .append("sewage_category", getSewage_category())
            .append("unit_type", getUnit_type())
            .append("other_unit_type", getOther_unit_type())
            .append("cflist", getCflist())
            .append("other_composition", getOther_composition())
            .append("water_diversion", getWater_diversion())
            .append("business_license", getBusiness_license())
            .append("social_credit_id", getSocial_credit_id())
            .append("drainage_license", getDrainage_license())
            .append("drainage_license_number", getDrainage_license_number())
            .append("drainage_license_begin_time", getDrainage_license_begin_time())
            .append("drainage_license_end_time", getDrainage_license_end_time())
            .append("sewage_license", getSewage_license())
            .append("sewage_license_number", getSewage_license_number())
            .append("sewage_license_begin_time", getSewage_license_begin_time())
            .append("sewage_license_end_time", getSewage_license_end_time())
            .append("note", getNote())
            .append("registration_time", getRegistration_time())
            .append("registration_person", getRegistration_person())
            .append("update_time", getUpdate_time())
            .append("update_person", getUpdate_person())
            .append("parent_household_id", getParent_household_id())
            .append("addressbz", getAddressbz())
            .append("maintypeidx", getMaintypeidx())
            .append("hascycert", getHascycert())
            .append("cycertno", getCycertno())
            .append("cydate1", getCydate1())
            .append("cydate2", getCydate2())
            .append("psknum", getPsknum())
            .append("yspsknum", getYspsknum())
            .append("wspsknum", getWspsknum())
            .append("hhpsknum", getHhpsknum())
            .append("recorder", getRecorder())
            .append("levelchar", getLevelchar())
            .append("hassh", getHassh())
            .append("needzz", getNeedzz())
            .append("needpscert", getNeedpscert())
            .append("needpwcert", getNeedpwcert())
            .append("needcycert", getNeedcycert())
            .append("importbz", getImportbz())
            .append("building", getBuilding())
            .append("hasdevice", getHasdevice())
            .toString();
    }

	public int getHousehold_id() {
		return household_id;
	}

	public void setHousehold_id(int household_id) {
		this.household_id = household_id;
	}

	public String getHousehold_name() {
		return household_name;
	}

	public void setHousehold_name(String household_name) {
		this.household_name = household_name;
	}

	public String getRecord_state() {
		return record_state;
	}

	public void setRecord_state(String record_state) {
		this.record_state = record_state;
	}

	public String getDoorplate_detail_address() {
		return doorplate_detail_address;
	}

	public void setDoorplate_detail_address(String doorplate_detail_address) {
		this.doorplate_detail_address = doorplate_detail_address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getAdministrative_name() {
		return administrative_name;
	}

	public void setAdministrative_name(String administrative_name) {
		this.administrative_name = administrative_name;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCommittees() {
		return committees;
	}

	public void setCommittees(String committees) {
		this.committees = committees;
	}

	public String getLane_name() {
		return lane_name;
	}

	public void setLane_name(String lane_name) {
		this.lane_name = lane_name;
	}

	public String getDoorplate_number() {
		return doorplate_number;
	}

	public void setDoorplate_number(String doorplate_number) {
		this.doorplate_number = doorplate_number;
	}

	public String getHousehold_level() {
		return household_level;
	}

	public void setHousehold_level(String household_level) {
		this.household_level = household_level;
	}

	public String getParent_household_name() {
		return parent_household_name;
	}

	public void setParent_household_name(String parent_household_name) {
		this.parent_household_name = parent_household_name;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public double getCover_area() {
		return cover_area;
	}

	public void setCover_area(double cover_area) {
		this.cover_area = cover_area;
	}

	public String getWater_meter_id() {
		return water_meter_id;
	}

	public void setWater_meter_id(String water_meter_id) {
		this.water_meter_id = water_meter_id;
	}

	public String getSewage_category() {
		return sewage_category;
	}

	public void setSewage_category(String sewage_category) {
		this.sewage_category = sewage_category;
	}

	public String getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}

	public String getOther_unit_type() {
		return other_unit_type;
	}

	public void setOther_unit_type(String other_unit_type) {
		this.other_unit_type = other_unit_type;
	}

	public String getCflist() {
		return cflist;
	}

	public void setCflist(String cflist) {
		this.cflist = cflist;
	}

	public String getOther_composition() {
		return other_composition;
	}

	public void setOther_composition(String other_composition) {
		this.other_composition = other_composition;
	}

	public String getWater_diversion() {
		return water_diversion;
	}

	public void setWater_diversion(String water_diversion) {
		this.water_diversion = water_diversion;
	}

	public String getBusiness_license() {
		return business_license;
	}

	public void setBusiness_license(String business_license) {
		this.business_license = business_license;
	}

	public String getSocial_credit_id() {
		return social_credit_id;
	}

	public void setSocial_credit_id(String social_credit_id) {
		this.social_credit_id = social_credit_id;
	}

	public String getDrainage_license() {
		return drainage_license;
	}

	public void setDrainage_license(String drainage_license) {
		this.drainage_license = drainage_license;
	}

	public String getDrainage_license_number() {
		return drainage_license_number;
	}

	public void setDrainage_license_number(String drainage_license_number) {
		this.drainage_license_number = drainage_license_number;
	}

	public String getDrainage_license_begin_time() {
		return drainage_license_begin_time;
	}

	public void setDrainage_license_begin_time(String drainage_license_begin_time) {
		this.drainage_license_begin_time = drainage_license_begin_time;
	}

	public String getDrainage_license_end_time() {
		return drainage_license_end_time;
	}

	public void setDrainage_license_end_time(String drainage_license_end_time) {
		this.drainage_license_end_time = drainage_license_end_time;
	}

	public String getSewage_license() {
		return sewage_license;
	}

	public void setSewage_license(String sewage_license) {
		this.sewage_license = sewage_license;
	}

	public String getSewage_license_number() {
		return sewage_license_number;
	}

	public void setSewage_license_number(String sewage_license_number) {
		this.sewage_license_number = sewage_license_number;
	}

	public String getSewage_license_begin_time() {
		return sewage_license_begin_time;
	}

	public void setSewage_license_begin_time(String sewage_license_begin_time) {
		this.sewage_license_begin_time = sewage_license_begin_time;
	}

	public String getSewage_license_end_time() {
		return sewage_license_end_time;
	}

	public void setSewage_license_end_time(String sewage_license_end_time) {
		this.sewage_license_end_time = sewage_license_end_time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRegistration_time() {
		return registration_time;
	}

	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}

	public int getRegistration_person() {
		return registration_person;
	}

	public void setRegistration_person(int registration_person) {
		this.registration_person = registration_person;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getUpdate_person() {
		return update_person;
	}

	public void setUpdate_person(String update_person) {
		this.update_person = update_person;
	}

	public int getParent_household_id() {
		return parent_household_id;
	}

	public void setParent_household_id(int parent_household_id) {
		this.parent_household_id = parent_household_id;
	}

	public String getAddressbz() {
		return addressbz;
	}

	public void setAddressbz(String addressbz) {
		this.addressbz = addressbz;
	}

	public int getMaintypeidx() {
		return maintypeidx;
	}

	public void setMaintypeidx(int maintypeidx) {
		this.maintypeidx = maintypeidx;
	}

	public String getHascycert() {
		return hascycert;
	}

	public void setHascycert(String hascycert) {
		this.hascycert = hascycert;
	}

	public String getCycertno() {
		return cycertno;
	}

	public void setCycertno(String cycertno) {
		this.cycertno = cycertno;
	}

	public String getCydate1() {
		return cydate1;
	}

	public void setCydate1(String cydate1) {
		this.cydate1 = cydate1;
	}

	public String getCydate2() {
		return cydate2;
	}

	public void setCydate2(String cydate2) {
		this.cydate2 = cydate2;
	}

	public int getPsknum() {
		return psknum;
	}

	public void setPsknum(int psknum) {
		this.psknum = psknum;
	}

	public int getYspsknum() {
		return yspsknum;
	}

	public void setYspsknum(int yspsknum) {
		this.yspsknum = yspsknum;
	}

	public int getWspsknum() {
		return wspsknum;
	}

	public void setWspsknum(int wspsknum) {
		this.wspsknum = wspsknum;
	}

	public int getHhpsknum() {
		return hhpsknum;
	}

	public void setHhpsknum(int hhpsknum) {
		this.hhpsknum = hhpsknum;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public String getLevelchar() {
		return levelchar;
	}

	public void setLevelchar(String levelchar) {
		this.levelchar = levelchar;
	}

	public int getHassh() {
		return hassh;
	}

	public void setHassh(int hassh) {
		this.hassh = hassh;
	}

	public String getNeedzz() {
		return needzz;
	}

	public void setNeedzz(String needzz) {
		this.needzz = needzz;
	}

	public String getNeedpscert() {
		return needpscert;
	}

	public void setNeedpscert(String needpscert) {
		this.needpscert = needpscert;
	}

	public String getNeedpwcert() {
		return needpwcert;
	}

	public void setNeedpwcert(String needpwcert) {
		this.needpwcert = needpwcert;
	}

	public String getNeedcycert() {
		return needcycert;
	}

	public void setNeedcycert(String needcycert) {
		this.needcycert = needcycert;
	}

	public String getImportbz() {
		return importbz;
	}

	public void setImportbz(String importbz) {
		this.importbz = importbz;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getHasdevice() {
		return hasdevice;
	}

	public void setHasdevice(String hasdevice) {
		this.hasdevice = hasdevice;
	}
}
