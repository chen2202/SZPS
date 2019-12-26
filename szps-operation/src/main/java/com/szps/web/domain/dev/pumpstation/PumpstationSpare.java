package com.szps.web.domain.dev.pumpstation;

import com.szps.common.core.domain.BaseEntity;

/**
 * 备品备件表
 * 
 * @author Jack
 *
 */
public class PumpstationSpare extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -832850094101279834L;
	Long id;
	String devname;// 备件名称
	String dtype;// 类型
	String dnumber;// 编号
	String dmodel;// 型号规格
	String quantity;// 数量
	String unit;// 单位
	String unitprice;// 单价
	String idnumber;// 出厂编号
	String releasedate;// 出厂日期
	String supplierid;// 供应商ID
	String supplier;// 供应商
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
	public String getDevname() {
		return devname;
	}
	public void setDevname(String devname) {
		this.devname = devname;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public String getDnumber() {
		return dnumber;
	}
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	public String getDmodel() {
		return dmodel;
	}
	public void setDmodel(String dmodel) {
		this.dmodel = dmodel;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

}
