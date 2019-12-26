package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class MHC extends BaseEntity {
	private static final long serialVersionUID = -4503872105149032924L;
	Long id;
	String dprovince;
	String dcity;
	String projectcode;
	String projectname;
	String reportnumber;
	String designscale;
	String awtc;
	String mdtc;
	String loadrate;
	String codrc;
	String codr;
	String codcptw;
	String twr;
	String cec;
	String directcost;
	String rwc;
	String awsp;
	String mcs;
	String stc;
	String landuse;
	String ubm;
	String iu;
	String slc;
	String odc;
	String normaldays;
	String standarddays;
	String reasons;
	String esp;
	String codin;
	String codout;
	String bodin;
	String bodout;
	String ssin;
	String ssout;
	String adin;
	String adout;
	String tnin;
	String tnout;
	String tpin;
	String tpout;
	String applicant;
	String submissiondate;

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

	public String getDprovince() {
		return dprovince;
	}

	public void setDprovince(String dprovince) {
		this.dprovince = dprovince;
	}

	public String getDcity() {
		return dcity;
	}

	public void setDcity(String dcity) {
		this.dcity = dcity;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getReportnumber() {
		return reportnumber;
	}

	public void setReportnumber(String reportnumber) {
		this.reportnumber = reportnumber;
	}

	public String getDesignscale() {
		return designscale;
	}

	public void setDesignscale(String designscale) {
		this.designscale = designscale;
	}

	public String getAwtc() {
		return awtc;
	}

	public void setAwtc(String awtc) {
		this.awtc = awtc;
	}

	public String getMdtc() {
		return mdtc;
	}

	public void setMdtc(String mdtc) {
		this.mdtc = mdtc;
	}

	public String getLoadrate() {
		return loadrate;
	}

	public void setLoadrate(String loadrate) {
		this.loadrate = loadrate;
	}

	public String getCodrc() {
		return codrc;
	}

	public void setCodrc(String codrc) {
		this.codrc = codrc;
	}

	public String getCodr() {
		return codr;
	}

	public void setCodr(String codr) {
		this.codr = codr;
	}

	public String getCodcptw() {
		return codcptw;
	}

	public void setCodcptw(String codcptw) {
		this.codcptw = codcptw;
	}

	public String getTwr() {
		return twr;
	}

	public void setTwr(String twr) {
		this.twr = twr;
	}

	public String getCec() {
		return cec;
	}

	public void setCec(String cec) {
		this.cec = cec;
	}

	public String getDirectcost() {
		return directcost;
	}

	public void setDirectcost(String directcost) {
		this.directcost = directcost;
	}

	public String getRwc() {
		return rwc;
	}

	public void setRwc(String rwc) {
		this.rwc = rwc;
	}

	public String getAwsp() {
		return awsp;
	}

	public void setAwsp(String awsp) {
		this.awsp = awsp;
	}

	public String getMcs() {
		return mcs;
	}

	public void setMcs(String mcs) {
		this.mcs = mcs;
	}

	public String getStc() {
		return stc;
	}

	public void setStc(String stc) {
		this.stc = stc;
	}

	public String getLanduse() {
		return landuse;
	}

	public void setLanduse(String landuse) {
		this.landuse = landuse;
	}

	public String getUbm() {
		return ubm;
	}

	public void setUbm(String ubm) {
		this.ubm = ubm;
	}

	public String getIu() {
		return iu;
	}

	public void setIu(String iu) {
		this.iu = iu;
	}

	public String getSlc() {
		return slc;
	}

	public void setSlc(String slc) {
		this.slc = slc;
	}

	public String getOdc() {
		return odc;
	}

	public void setOdc(String odc) {
		this.odc = odc;
	}

	public String getNormaldays() {
		return normaldays;
	}

	public void setNormaldays(String normaldays) {
		this.normaldays = normaldays;
	}

	public String getStandarddays() {
		return standarddays;
	}

	public void setStandarddays(String standarddays) {
		this.standarddays = standarddays;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}

	public String getCodin() {
		return codin;
	}

	public void setCodin(String codin) {
		this.codin = codin;
	}

	public String getCodout() {
		return codout;
	}

	public void setCodout(String codout) {
		this.codout = codout;
	}

	public String getBodin() {
		return bodin;
	}

	public void setBodin(String bodin) {
		this.bodin = bodin;
	}

	public String getBodout() {
		return bodout;
	}

	public void setBodout(String bodout) {
		this.bodout = bodout;
	}

	public String getSsin() {
		return ssin;
	}

	public void setSsin(String ssin) {
		this.ssin = ssin;
	}

	public String getSsout() {
		return ssout;
	}

	public void setSsout(String ssout) {
		this.ssout = ssout;
	}

	public String getAdin() {
		return adin;
	}

	public void setAdin(String adin) {
		this.adin = adin;
	}

	public String getAdout() {
		return adout;
	}

	public void setAdout(String adout) {
		this.adout = adout;
	}

	public String getTnin() {
		return tnin;
	}

	public void setTnin(String tnin) {
		this.tnin = tnin;
	}

	public String getTnout() {
		return tnout;
	}

	public void setTnout(String tnout) {
		this.tnout = tnout;
	}

	public String getTpin() {
		return tpin;
	}

	public void setTpin(String tpin) {
		this.tpin = tpin;
	}

	public String getTpout() {
		return tpout;
	}

	public void setTpout(String tpout) {
		this.tpout = tpout;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getSubmissiondate() {
		return submissiondate;
	}

	public void setSubmissiondate(String submissiondate) {
		this.submissiondate = submissiondate;
	}

}
