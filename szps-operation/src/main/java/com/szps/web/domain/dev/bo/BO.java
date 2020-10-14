package com.szps.web.domain.dev.bo;

import com.szps.common.core.domain.BaseEntity;

/**
 * 调蓄池(CSDT)
 * 
 * @author Jack
 *
 */
public class BO extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1050469789430789585L;
	private Long id;
	private String dnumber;// 资产编号
	private String dtype;// 资产类别
	private String dname;// 资产名称
	private String dbrand;// 设备品牌
	private String dmodel;// 规格型号
	private String buytime;// 购买时间
	private String beganusetime;// 投用时间
	private String installationsite;// 安装位置
	private String dstatus;// 设备状态
	Long supplierid;// 供应商id
	String dsupplier;// 供应商

	Long dept_id;//CREATE_BY 部门ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getDbrand() {
		return dbrand;
	}

	public void setDbrand(String dbrand) {
		this.dbrand = dbrand;
	}

	public String getDmodel() {
		return dmodel;
	}

	public void setDmodel(String dmodel) {
		this.dmodel = dmodel;
	}

	public String getBuytime() {
		return buytime;
	}

	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}

	public String getBeganusetime() {
		return beganusetime;
	}

	public void setBeganusetime(String beganusetime) {
		this.beganusetime = beganusetime;
	}

	public String getInstallationsite() {
		return installationsite;
	}

	public void setInstallationsite(String installationsite) {
		this.installationsite = installationsite;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public Long getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Long supplierid) {
		this.supplierid = supplierid;
	}

	public String getDsupplier() {
		return dsupplier;
	}

	public void setDsupplier(String dsupplier) {
		this.dsupplier = dsupplier;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

}
