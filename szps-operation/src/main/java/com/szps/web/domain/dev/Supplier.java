package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Supplier extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -45497692344319282L;
	private Long id;
	private String sname;// 名称
	private String contact;// 联系人
	private String tel;// 联系电话
	private String addr;// 地址
	private Integer stype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getStype() {
		return stype;
	}

	public void setStype(Integer stype) {
		this.stype = stype;
	}

}
