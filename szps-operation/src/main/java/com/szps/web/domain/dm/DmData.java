package com.szps.web.domain.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.szps.common.annotation.Excel;
import com.szps.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.szps.common.core.domain.BaseEntity;

/**
 * 资料表
 * 
 * @author vic
 *
 */
public class DmData extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	/** 资料ID */
	@Excel(name = "资料序号", prompt = "资料编号")
	private Long dataId;
	
	/** 申请编号 */
	private String dataUuid;
	
	/** 申请日期 */
	@Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	private Date dataDate;
	
	/** 申请人 */
	@Excel(name = "申请人")
	private String dataApplicant;
	
	/** 规划单位 */
	@Excel(name = "规划单位")
	private String dataCompany;
	
	/** 行政区 */
	@Excel(name = "行政区")
	private String dataBorough;
	
	/** 街道 */
	@Excel(name = "街道",width = 30)
	private String dataStreet;
	
	/** 所属类别 */
	@Excel(name = "所属类别")
	private String dataType;
	
	/** 密级 */
	@Excel(name = "密级")
	private String dataLevel;
	
	/** 主题 */
	@Excel(name = "主题",width = 30)
	private String dataTheme;
	
	/** 简介 */
	@Excel(name = "简介",width = 50)
	private String dataDesc;
	
	/** 删除标志 （0代表存在 2代表删除） */
	private String dataFlag;

	/** 流域 */
	private String dataRiver;

	/** 审批信息 */
	private DmAudit audit;

	public DmAudit getAudit() {
		if (audit == null)
		{
			audit = new DmAudit();
		}
		return audit;
	}

	public void setAudit(DmAudit audit) {
		this.audit = audit;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public String getDataUuid() {
		return dataUuid;
	}

	public void setDataUuid(String dataUuid) {
		this.dataUuid = dataUuid;
	}

	public Date getDataDate() {
		return dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	public String getDataApplicant() {
		return dataApplicant;
	}

	public void setDataApplicant(String dataApplicant) {
		this.dataApplicant = dataApplicant;
	}

	public String getDataCompany() {
		return dataCompany;
	}

	public void setDataCompany(String dataCompany) {
		this.dataCompany = dataCompany;
	}

	public String getDataBorough() {
		return dataBorough;
	}

	public void setDataBorough(String dataBorough) {
		this.dataBorough = dataBorough;
	}

	public String getDataStreet() {
		return dataStreet;
	}

	public void setDataStreet(String dataStreet) {
		this.dataStreet = dataStreet;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataLevel() {
		return dataLevel;
	}

	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}

	public String getDataTheme() {
		return dataTheme;
	}

	public void setDataTheme(String dataTheme) {
		this.dataTheme = dataTheme;
	}

	public String getDataDesc() {
		return dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

	public String getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}

	public String getDataRiver() {
		return dataRiver;
	}

	public void setDataRiver(String dataRiver) {
		this.dataRiver = dataRiver;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	            .append("dataId", getDataId())
	            .append("dataUuid", getDataUuid())
	            .append("dataDate", getDataDate())
	            .append("dataApplicant", getDataApplicant())
	            .append("dataCompany", getDataCompany())
	            .append("dataBorough", getDataBorough())
	            .append("dataStreet", getDataStreet())
	            .append("dataType", getDataType())
	            .append("dataLevel", getDataLevel())
	            .append("dataTheme", getDataTheme())
	            .append("dataDesc", getDataDesc())
	            .append("dataFlag", getDataFlag())
	            .append("dataRiver", getDataRiver())
	            .append("audit", getAudit())
	            .toString();
	}
	
	
	
}
