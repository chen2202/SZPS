package com.szps.web.domain.dev.drainagenetwork;

import com.szps.common.core.domain.BaseEntity;

public class PS_OUTFALL extends BaseEntity{

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
	String bottom_elev;
	String outfallshape;
	String outfalltype;
	String offset;
	String rotation;
	String code;
	String flap;
	String flap_diameter;
	String flap_topele;
	String flap_botele;
	String flap_materail;
	String receivewater;
	String address;
	String pointposition;
	String datasource;
	String visibility;
	String sunit;
	String sdate;
	String updatetime;
	String mdate;
	String outfall_type;
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
	public String getBottom_elev() {
		return bottom_elev;
	}
	public void setBottom_elev(String bottom_elev) {
		this.bottom_elev = bottom_elev;
	}
	public String getOutfallshape() {
		return outfallshape;
	}
	public void setOutfallshape(String outfallshape) {
		this.outfallshape = outfallshape;
	}
	public String getOutfalltype() {
		return outfalltype;
	}
	public void setOutfalltype(String outfalltype) {
		this.outfalltype = outfalltype;
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
	public String getFlap() {
		return flap;
	}
	public void setFlap(String flap) {
		this.flap = flap;
	}
	public String getFlap_diameter() {
		return flap_diameter;
	}
	public void setFlap_diameter(String flap_diameter) {
		this.flap_diameter = flap_diameter;
	}
	public String getFlap_topele() {
		return flap_topele;
	}
	public void setFlap_topele(String flap_topele) {
		this.flap_topele = flap_topele;
	}
	public String getFlap_botele() {
		return flap_botele;
	}
	public void setFlap_botele(String flap_botele) {
		this.flap_botele = flap_botele;
	}
	public String getFlap_materail() {
		return flap_materail;
	}
	public void setFlap_materail(String flap_materail) {
		this.flap_materail = flap_materail;
	}
	public String getReceivewater() {
		return receivewater;
	}
	public void setReceivewater(String receivewater) {
		this.receivewater = receivewater;
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
	public String getOutfall_type() {
		return outfall_type;
	}
	public void setOutfall_type(String outfall_type) {
		this.outfall_type = outfall_type;
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
