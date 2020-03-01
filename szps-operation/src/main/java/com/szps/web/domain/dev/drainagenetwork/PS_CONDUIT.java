package com.szps.web.domain.dev.drainagenetwork;

import com.szps.common.core.domain.BaseEntity;

public class PS_CONDUIT extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5037575193966753285L;
	String prj_no;
	String prj_name;
	String lno;
	String grade;
	String s_point;
	String s_deep;
	String in_elev;
	String e_point;
	String e_deep;
	String out_elev;
	String sewagesystem_id;
	String stormsystem_id;
	String conduit_style1;
	String conduit_style2;
	String type;
	String code;
	String material;
	String servicelife;
	String shapetype;
	String shape_data1;
	String shape_data2;
	String shape_data3;
	String shape_data4;
	String shape_xydata;
	String pipelength;
	String flowdir;
	String embed;
	String interfaceP;//
	String address;
	String datasource;
	String sunit;
	String sdate;
	String updatetime;
	String mdate;
	String plan;
	String conduit_type;
	String status;
	String ename;
	String design_dept;
	String conster_dept;
	String belong;
	String operator;
	String note;
	String shape_length;
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
	public String getLno() {
		return lno;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getS_point() {
		return s_point;
	}
	public void setS_point(String s_point) {
		this.s_point = s_point;
	}
	public String getS_deep() {
		return s_deep;
	}
	public void setS_deep(String s_deep) {
		this.s_deep = s_deep;
	}
	public String getIn_elev() {
		return in_elev;
	}
	public void setIn_elev(String in_elev) {
		this.in_elev = in_elev;
	}
	public String getE_point() {
		return e_point;
	}
	public void setE_point(String e_point) {
		this.e_point = e_point;
	}
	public String getE_deep() {
		return e_deep;
	}
	public void setE_deep(String e_deep) {
		this.e_deep = e_deep;
	}
	public String getOut_elev() {
		return out_elev;
	}
	public void setOut_elev(String out_elev) {
		this.out_elev = out_elev;
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
	public String getConduit_style1() {
		return conduit_style1;
	}
	public void setConduit_style1(String conduit_style1) {
		this.conduit_style1 = conduit_style1;
	}
	public String getConduit_style2() {
		return conduit_style2;
	}
	public void setConduit_style2(String conduit_style2) {
		this.conduit_style2 = conduit_style2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getServicelife() {
		return servicelife;
	}
	public void setServicelife(String servicelife) {
		this.servicelife = servicelife;
	}
	public String getShapetype() {
		return shapetype;
	}
	public void setShapetype(String shapetype) {
		this.shapetype = shapetype;
	}
	public String getShape_data1() {
		return shape_data1;
	}
	public void setShape_data1(String shape_data1) {
		this.shape_data1 = shape_data1;
	}
	public String getShape_data2() {
		return shape_data2;
	}
	public void setShape_data2(String shape_data2) {
		this.shape_data2 = shape_data2;
	}
	public String getShape_data3() {
		return shape_data3;
	}
	public void setShape_data3(String shape_data3) {
		this.shape_data3 = shape_data3;
	}
	public String getShape_data4() {
		return shape_data4;
	}
	public void setShape_data4(String shape_data4) {
		this.shape_data4 = shape_data4;
	}
	public String getShape_xydata() {
		return shape_xydata;
	}
	public void setShape_xydata(String shape_xydata) {
		this.shape_xydata = shape_xydata;
	}
	public String getPipelength() {
		return pipelength;
	}
	public void setPipelength(String pipelength) {
		this.pipelength = pipelength;
	}
	public String getFlowdir() {
		return flowdir;
	}
	public void setFlowdir(String flowdir) {
		this.flowdir = flowdir;
	}
	public String getEmbed() {
		return embed;
	}
	public void setEmbed(String embed) {
		this.embed = embed;
	}
	public String getInterfaceP() {
		return interfaceP;
	}
	public void setInterfaceP(String interfaceP) {
		this.interfaceP = interfaceP;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
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
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getConduit_type() {
		return conduit_type;
	}
	public void setConduit_type(String conduit_type) {
		this.conduit_type = conduit_type;
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
	public String getShape_length() {
		return shape_length;
	}
	public void setShape_length(String shape_length) {
		this.shape_length = shape_length;
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
