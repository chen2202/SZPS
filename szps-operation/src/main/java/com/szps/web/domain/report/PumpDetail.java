package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;
/**
 * 污水泵站固定资产清单
 * @author Jack
 *
 */
public class PumpDetail extends BaseEntity {
	private static final long serialVersionUID = -4503872105149032924L;
	Long id;
	Long pumpid;
	String dtype;
	Integer dnumber;
	String assetname;
	String supplyer;
	String dspec;
	String dunit;
	String areaorquantity;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPumpid() {
		return pumpid;
	}
	public void setPumpid(Long pumpid) {
		this.pumpid = pumpid;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	public Integer getDnumber() {
		return dnumber;
	}
	public void setDnumber(Integer dnumber) {
		this.dnumber = dnumber;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getSupplyer() {
		return supplyer;
	}
	public void setSupplyer(String supplyer) {
		this.supplyer = supplyer;
	}
	public String getDspec() {
		return dspec;
	}
	public void setDspec(String dspec) {
		this.dspec = dspec;
	}
	public String getDunit() {
		return dunit;
	}
	public void setDunit(String dunit) {
		this.dunit = dunit;
	}
	public String getAreaorquantity() {
		return areaorquantity;
	}
	public void setAreaorquantity(String areaorquantity) {
		this.areaorquantity = areaorquantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
