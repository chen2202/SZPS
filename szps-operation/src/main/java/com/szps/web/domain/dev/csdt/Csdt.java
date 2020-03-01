package com.szps.web.domain.dev.csdt;

import com.szps.common.core.domain.BaseEntity;

/**
 * 调蓄池(CSDT)
 * 
 * @author Jack
 *
 */
public class Csdt extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1050469789430789585L;
	private Long id;
	private String dlocation;// 资产位置
	private Long areaid;// 所属区id
	private String areaname;// 所属区
	private String dnumber;// 资产编号
	private String dname;// 资产名称
	private String dtype;// 资产类别
	private String dmodel;// 规格型号
	private Integer dqty;// 数量
	private String dunit;// 单位
	private String producedate;// 投产日期
	private Long supplierid;// 生产厂商id
	private String manufacturer;// 生产厂商
	private String purchasedate;// 购置日期
	private Long usedeptid;// 使用部门ID
	private String usedept;// 使用部门
	private String servicelife;// 使用年限
	private String dparameter;// 资产参数
	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDlocation() {
		return dlocation;
	}
	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}
	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getDnumber() {
		return dnumber;
	}
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getDmodel() {
		return dmodel;
	}
	public void setDmodel(String dmodel) {
		this.dmodel = dmodel;
	}
	public Integer getDqty() {
		return dqty;
	}
	public void setDqty(Integer dqty) {
		this.dqty = dqty;
	}
	public String getDunit() {
		return dunit;
	}
	public void setDunit(String dunit) {
		this.dunit = dunit;
	}
	public String getProducedate() {
		return producedate;
	}
	public void setProducedate(String producedate) {
		this.producedate = producedate;
	}
	public Long getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Long supplierid) {
		this.supplierid = supplierid;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public Long getUsedeptid() {
		return usedeptid;
	}
	public void setUsedeptid(Long usedeptid) {
		this.usedeptid = usedeptid;
	}
	public String getUsedept() {
		return usedept;
	}
	public void setUsedept(String usedept) {
		this.usedept = usedept;
	}
	public String getServicelife() {
		return servicelife;
	}
	public void setServicelife(String servicelife) {
		this.servicelife = servicelife;
	}
	public String getDparameter() {
		return dparameter;
	}
	public void setDparameter(String dparameter) {
		this.dparameter = dparameter;
	}

}
