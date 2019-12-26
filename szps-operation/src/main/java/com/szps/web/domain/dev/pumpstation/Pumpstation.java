package com.szps.web.domain.dev.pumpstation;

import com.szps.common.core.domain.BaseEntity;

/**
 * 调蓄池(CSDT)
 * 
 * @author Jack
 *
 */
public class Pumpstation extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1050469789430789585L;
	private Long id;
	String dname;// 名称
	Long areaid;// 所属区id
	String areaname;// 所属区
	String dtype;// 类型
	Long supplierid;// 供应商id
	String dsupplier;// 建设单位/生产厂家
	String dmodel;// 规格型号
	String dunit;// 单位
	String dqty;// 面积/数量

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

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
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

	public String getDmodel() {
		return dmodel;
	}

	public void setDmodel(String dmodel) {
		this.dmodel = dmodel;
	}

	public String getDunit() {
		return dunit;
	}

	public void setDunit(String dunit) {
		this.dunit = dunit;
	}

	public String getDqty() {
		return dqty;
	}

	public void setDqty(String dqty) {
		this.dqty = dqty;
	}

}
