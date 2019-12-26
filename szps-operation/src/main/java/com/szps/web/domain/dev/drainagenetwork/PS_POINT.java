package com.szps.web.domain.dev.drainagenetwork;

import com.szps.common.core.domain.BaseEntity;

public class PS_POINT extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 899310141472890288L;
	String prj_no;
	String prj_name;
	String mapcode;
	String exp_no;
	String sewagesystem_id;
	String stormsystem_id;
	String type;
	String x;
	String y;
	String high;
	String welldeep;
	String offset;
	String rotation;
	String code;
	String wellpipes;
	String waterdeep;
	String muddeep;
	String address;
	String pointposition;
	String datasource;
	String visibility;
	String sunit;
	String sdate;
	String updatetime;
	String mdate;
	String point_type;
	String status;
	String ename;
	String design_dept;
	String conster_dept;
	String belong;
	String operator;
	String note;
	String objectid;
	String areaid;
	String areaname;
	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public String getPrj_no() {
		return prj_no;
	}
	public void setPrj_no(String prj_no) {
		this.prj_no = prj_no;
	}
	public String getPrj_name() {
		return prj_name;
	}
	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	public String getMapcode() {
		return mapcode;
	}
	public void setMapcode(String mapcode) {
		this.mapcode = mapcode;
	}
	public String getExp_no() {
		return exp_no;
	}
	public void setExp_no(String exp_no) {
		this.exp_no = exp_no;
	}
	public String getSewagesystem_id() {
		return sewagesystem_id;
	}
	public void setSewagesystem_id(String sewagesystem_id) {
		this.sewagesystem_id = sewagesystem_id;
	}
	public String getStormsystem_id() {
		return stormsystem_id;
	}
	public void setStormsystem_id(String stormsystem_id) {
		this.stormsystem_id = stormsystem_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getWelldeep() {
		return welldeep;
	}
	public void setWelldeep(String welldeep) {
		this.welldeep = welldeep;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public String getRotation() {
		return rotation;
	}
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getWellpipes() {
		return wellpipes;
	}
	public void setWellpipes(String wellpipes) {
		this.wellpipes = wellpipes;
	}
	public String getWaterdeep() {
		return waterdeep;
	}
	public void setWaterdeep(String waterdeep) {
		this.waterdeep = waterdeep;
	}
	public String getMuddeep() {
		return muddeep;
	}
	public void setMuddeep(String muddeep) {
		this.muddeep = muddeep;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPointposition() {
		return pointposition;
	}
	public void setPointposition(String pointposition) {
		this.pointposition = pointposition;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getSunit() {
		return sunit;
	}
	public void setSunit(String sunit) {
		this.sunit = sunit;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getPoint_type() {
		return point_type;
	}
	public void setPoint_type(String point_type) {
		this.point_type = point_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesign_dept() {
		return design_dept;
	}
	public void setDesign_dept(String design_dept) {
		this.design_dept = design_dept;
	}
	public String getConster_dept() {
		return conster_dept;
	}
	public void setConster_dept(String conster_dept) {
		this.conster_dept = conster_dept;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}
