package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class PsProgressN extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -784717877188568306L;
	Long id;
	String xzqy_q;//行政区域--区
	String xzqy_j;//行政区域--街道
	String duedate;//截止时间
	String buildingtype;//建筑类型
	String jzxq_s;//建筑小区 实有数量（个）
	String jzxq_q;//建筑小区 签订协议（个）
	String jzxq_y;//建筑小区 移交接管（个）
	String jzxq_z;//建筑小区 自行管养（个）
	String psgwg_h;//排水管网估算长度 合计
	String psgwg_y;//排水管网估算长度 雨水
	String psgwg_w;//排水管网估算长度 污水
	String gwch_wg_xq;//管网测绘（公里）已完工 建筑小区
	String gwch_wg_h;//管网测绘（公里）已完工 合计
	String gwch_wg_y;//管网测绘（公里）已完工 雨水
	String gwch_wg_w;//管网测绘（公里）已完工 污水
	String gwch_zzkz_xq;//管网测绘（公里）正在开展 建筑小区
	String gwch_zzkz_h;//管网测绘（公里）正在开展 合计
	String gwch_zzkz_y;//管网测绘（公里）正在开展 雨水
	String gwch_zzkz_w;//管网测绘（公里）正在开展 污水
	String gwzc_wg_xq;//管网检测（公里）已完工 建筑小区
	String gwzc_wg_h;//管网检测（公里）已完工 合计
	String gwzc_wg_y;//管网检测（公里）已完工 雨水
	String gwzc_wg_w;//管网检测（公里）已完工 污水
	String gwzc_zzkz_xq;//管网检测（公里）正在开展 建筑小区
	String gwzc_zzkz_h;//管网检测（公里）正在开展 合计
	String gwzc_zzkz_y;//管网检测（公里）正在开展 雨水
	String gwzc_zzkz_w;//管网检测（公里）正在开展 污水
	String gwqy_wg_xq;//管网清淤（公里）已完工 建筑小区
	String gwqy_wg_h;//管网清淤（公里）已完工 合计
	String gwqy_wg_y;//管网清淤（公里）已完工 雨水
	String gwqy_wg_w;//管网清淤（公里）已完工 污水
	String gwqy_wg_qy;//管网清淤（公里）已完工 清淤量
	String gwqy_zzkz_xq;//管网清淤（公里）正在开展 建筑小区
	String gwqy_zzkz_h;//管网清淤（公里）正在开展 合计
	String gwqy_zzkz_y;//管网清淤（公里）正在开展 雨水
	String gwqy_zzkz_w;//管网清淤（公里）正在开展 污水
	String gwqy_zzkz_qy;//管网清淤（公里）正在开展 清淤量
	String gwxf_wg_xq;//管网修复（点）已完工 建筑小区
	String gwxf_wg_h;//管网修复（点）已完工 合计
	String gwxf_wg_y;//管网修复（点）已完工 雨水
	String gwxf_wg_w;//管网修复（点）已完工 污水
	String gwxf_wg_hld;//管网修复（点）已完工 混流点整改
	String gwxf_zzkz_xq;//管网修复（点）正在开展 建筑小区
	String gwxf_zzkz_h;//管网修复（点）正在开展 合计
	String gwxf_zzkz_y;//管网修复（点）正在开展 雨水
	String gwxf_zzkz_w;//管网修复（点）正在开展 污水
	String gwxf_zzkz_hld;//管网修复（点）正在开展 混流点整改
	String jcj_h;//检查井合计
	String jcj_y;//检查井雨水
	String jcj_w;//检查井污水
	String ysk;//雨水口（个）
	String psh_h;//排水户合计
	String psh_y;//排水户一级
	String psh_e;//排水户二级
	String hfc;//化粪池（个）
	String ljc;//垃圾池(个）
	String gyc;//隔油池（个）

	Long dept_id;//CREATE_BY 部门ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXzqy_q() {
		return xzqy_q;
	}

	public void setXzqy_q(String xzqy_q) {
		this.xzqy_q = xzqy_q;
	}

	public String getXzqy_j() {
		return xzqy_j;
	}

	public void setXzqy_j(String xzqy_j) {
		this.xzqy_j = xzqy_j;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getBuildingtype() {
		return buildingtype;
	}

	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}

	public String getJzxq_s() {
		return jzxq_s;
	}

	public void setJzxq_s(String jzxq_s) {
		this.jzxq_s = jzxq_s;
	}

	public String getJzxq_q() {
		return jzxq_q;
	}

	public void setJzxq_q(String jzxq_q) {
		this.jzxq_q = jzxq_q;
	}

	public String getJzxq_y() {
		return jzxq_y;
	}

	public void setJzxq_y(String jzxq_y) {
		this.jzxq_y = jzxq_y;
	}

	public String getJzxq_z() {
		return jzxq_z;
	}

	public void setJzxq_z(String jzxq_z) {
		this.jzxq_z = jzxq_z;
	}

	public String getPsgwg_h() {
		return psgwg_h;
	}

	public void setPsgwg_h(String psgwg_h) {
		this.psgwg_h = psgwg_h;
	}

	public String getPsgwg_y() {
		return psgwg_y;
	}

	public void setPsgwg_y(String psgwg_y) {
		this.psgwg_y = psgwg_y;
	}

	public String getPsgwg_w() {
		return psgwg_w;
	}

	public void setPsgwg_w(String psgwg_w) {
		this.psgwg_w = psgwg_w;
	}

	public String getGwch_wg_xq() {
		return gwch_wg_xq;
	}

	public void setGwch_wg_xq(String gwch_wg_xq) {
		this.gwch_wg_xq = gwch_wg_xq;
	}

	public String getGwch_wg_h() {
		return gwch_wg_h;
	}

	public void setGwch_wg_h(String gwch_wg_h) {
		this.gwch_wg_h = gwch_wg_h;
	}

	public String getGwch_wg_y() {
		return gwch_wg_y;
	}

	public void setGwch_wg_y(String gwch_wg_y) {
		this.gwch_wg_y = gwch_wg_y;
	}

	public String getGwch_wg_w() {
		return gwch_wg_w;
	}

	public void setGwch_wg_w(String gwch_wg_w) {
		this.gwch_wg_w = gwch_wg_w;
	}

	public String getGwch_zzkz_xq() {
		return gwch_zzkz_xq;
	}

	public void setGwch_zzkz_xq(String gwch_zzkz_xq) {
		this.gwch_zzkz_xq = gwch_zzkz_xq;
	}

	public String getGwch_zzkz_h() {
		return gwch_zzkz_h;
	}

	public void setGwch_zzkz_h(String gwch_zzkz_h) {
		this.gwch_zzkz_h = gwch_zzkz_h;
	}

	public String getGwch_zzkz_y() {
		return gwch_zzkz_y;
	}

	public void setGwch_zzkz_y(String gwch_zzkz_y) {
		this.gwch_zzkz_y = gwch_zzkz_y;
	}

	public String getGwch_zzkz_w() {
		return gwch_zzkz_w;
	}

	public void setGwch_zzkz_w(String gwch_zzkz_w) {
		this.gwch_zzkz_w = gwch_zzkz_w;
	}

	public String getGwzc_wg_xq() {
		return gwzc_wg_xq;
	}

	public void setGwzc_wg_xq(String gwzc_wg_xq) {
		this.gwzc_wg_xq = gwzc_wg_xq;
	}

	public String getGwzc_wg_h() {
		return gwzc_wg_h;
	}

	public void setGwzc_wg_h(String gwzc_wg_h) {
		this.gwzc_wg_h = gwzc_wg_h;
	}

	public String getGwzc_wg_y() {
		return gwzc_wg_y;
	}

	public void setGwzc_wg_y(String gwzc_wg_y) {
		this.gwzc_wg_y = gwzc_wg_y;
	}

	public String getGwzc_wg_w() {
		return gwzc_wg_w;
	}

	public void setGwzc_wg_w(String gwzc_wg_w) {
		this.gwzc_wg_w = gwzc_wg_w;
	}

	public String getGwzc_zzkz_xq() {
		return gwzc_zzkz_xq;
	}

	public void setGwzc_zzkz_xq(String gwzc_zzkz_xq) {
		this.gwzc_zzkz_xq = gwzc_zzkz_xq;
	}

	public String getGwzc_zzkz_h() {
		return gwzc_zzkz_h;
	}

	public void setGwzc_zzkz_h(String gwzc_zzkz_h) {
		this.gwzc_zzkz_h = gwzc_zzkz_h;
	}

	public String getGwzc_zzkz_y() {
		return gwzc_zzkz_y;
	}

	public void setGwzc_zzkz_y(String gwzc_zzkz_y) {
		this.gwzc_zzkz_y = gwzc_zzkz_y;
	}

	public String getGwzc_zzkz_w() {
		return gwzc_zzkz_w;
	}

	public void setGwzc_zzkz_w(String gwzc_zzkz_w) {
		this.gwzc_zzkz_w = gwzc_zzkz_w;
	}

	public String getGwqy_wg_xq() {
		return gwqy_wg_xq;
	}

	public void setGwqy_wg_xq(String gwqy_wg_xq) {
		this.gwqy_wg_xq = gwqy_wg_xq;
	}

	public String getGwqy_wg_h() {
		return gwqy_wg_h;
	}

	public void setGwqy_wg_h(String gwqy_wg_h) {
		this.gwqy_wg_h = gwqy_wg_h;
	}

	public String getGwqy_wg_y() {
		return gwqy_wg_y;
	}

	public void setGwqy_wg_y(String gwqy_wg_y) {
		this.gwqy_wg_y = gwqy_wg_y;
	}

	public String getGwqy_wg_w() {
		return gwqy_wg_w;
	}

	public void setGwqy_wg_w(String gwqy_wg_w) {
		this.gwqy_wg_w = gwqy_wg_w;
	}

	public String getGwqy_wg_qy() {
		return gwqy_wg_qy;
	}

	public void setGwqy_wg_qy(String gwqy_wg_qy) {
		this.gwqy_wg_qy = gwqy_wg_qy;
	}

	public String getGwqy_zzkz_xq() {
		return gwqy_zzkz_xq;
	}

	public void setGwqy_zzkz_xq(String gwqy_zzkz_xq) {
		this.gwqy_zzkz_xq = gwqy_zzkz_xq;
	}

	public String getGwqy_zzkz_h() {
		return gwqy_zzkz_h;
	}

	public void setGwqy_zzkz_h(String gwqy_zzkz_h) {
		this.gwqy_zzkz_h = gwqy_zzkz_h;
	}

	public String getGwqy_zzkz_y() {
		return gwqy_zzkz_y;
	}

	public void setGwqy_zzkz_y(String gwqy_zzkz_y) {
		this.gwqy_zzkz_y = gwqy_zzkz_y;
	}

	public String getGwqy_zzkz_w() {
		return gwqy_zzkz_w;
	}

	public void setGwqy_zzkz_w(String gwqy_zzkz_w) {
		this.gwqy_zzkz_w = gwqy_zzkz_w;
	}

	public String getGwqy_zzkz_qy() {
		return gwqy_zzkz_qy;
	}

	public void setGwqy_zzkz_qy(String gwqy_zzkz_qy) {
		this.gwqy_zzkz_qy = gwqy_zzkz_qy;
	}

	public String getGwxf_wg_xq() {
		return gwxf_wg_xq;
	}

	public void setGwxf_wg_xq(String gwxf_wg_xq) {
		this.gwxf_wg_xq = gwxf_wg_xq;
	}

	public String getGwxf_wg_h() {
		return gwxf_wg_h;
	}

	public void setGwxf_wg_h(String gwxf_wg_h) {
		this.gwxf_wg_h = gwxf_wg_h;
	}

	public String getGwxf_wg_y() {
		return gwxf_wg_y;
	}

	public void setGwxf_wg_y(String gwxf_wg_y) {
		this.gwxf_wg_y = gwxf_wg_y;
	}

	public String getGwxf_wg_w() {
		return gwxf_wg_w;
	}

	public void setGwxf_wg_w(String gwxf_wg_w) {
		this.gwxf_wg_w = gwxf_wg_w;
	}

	public String getGwxf_wg_hld() {
		return gwxf_wg_hld;
	}

	public void setGwxf_wg_hld(String gwxf_wg_hld) {
		this.gwxf_wg_hld = gwxf_wg_hld;
	}

	public String getGwxf_zzkz_xq() {
		return gwxf_zzkz_xq;
	}

	public void setGwxf_zzkz_xq(String gwxf_zzkz_xq) {
		this.gwxf_zzkz_xq = gwxf_zzkz_xq;
	}

	public String getGwxf_zzkz_h() {
		return gwxf_zzkz_h;
	}

	public void setGwxf_zzkz_h(String gwxf_zzkz_h) {
		this.gwxf_zzkz_h = gwxf_zzkz_h;
	}

	public String getGwxf_zzkz_y() {
		return gwxf_zzkz_y;
	}

	public void setGwxf_zzkz_y(String gwxf_zzkz_y) {
		this.gwxf_zzkz_y = gwxf_zzkz_y;
	}

	public String getGwxf_zzkz_w() {
		return gwxf_zzkz_w;
	}

	public void setGwxf_zzkz_w(String gwxf_zzkz_w) {
		this.gwxf_zzkz_w = gwxf_zzkz_w;
	}

	public String getGwxf_zzkz_hld() {
		return gwxf_zzkz_hld;
	}

	public void setGwxf_zzkz_hld(String gwxf_zzkz_hld) {
		this.gwxf_zzkz_hld = gwxf_zzkz_hld;
	}

	public String getJcj_h() {
		return jcj_h;
	}

	public void setJcj_h(String jcj_h) {
		this.jcj_h = jcj_h;
	}

	public String getJcj_y() {
		return jcj_y;
	}

	public void setJcj_y(String jcj_y) {
		this.jcj_y = jcj_y;
	}

	public String getJcj_w() {
		return jcj_w;
	}

	public void setJcj_w(String jcj_w) {
		this.jcj_w = jcj_w;
	}

	public String getYsk() {
		return ysk;
	}

	public void setYsk(String ysk) {
		this.ysk = ysk;
	}

	public String getPsh_h() {
		return psh_h;
	}

	public void setPsh_h(String psh_h) {
		this.psh_h = psh_h;
	}

	public String getPsh_y() {
		return psh_y;
	}

	public void setPsh_y(String psh_y) {
		this.psh_y = psh_y;
	}

	public String getPsh_e() {
		return psh_e;
	}

	public void setPsh_e(String psh_e) {
		this.psh_e = psh_e;
	}

	public String getHfc() {
		return hfc;
	}

	public void setHfc(String hfc) {
		this.hfc = hfc;
	}

	public String getLjc() {
		return ljc;
	}

	public void setLjc(String ljc) {
		this.ljc = ljc;
	}

	public String getGyc() {
		return gyc;
	}

	public void setGyc(String gyc) {
		this.gyc = gyc;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

}
