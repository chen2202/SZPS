package com.szps.web.domain.dm;

import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 规划审核表
 *
 * @author vic
 *
 */
public class DmAudit extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 审批ID */
    private Long auditId;

    /** 资料ID */
    private Long dataId;

    /** 用户ID */
    private Long userId;

    /** 审批人 */
    private String userName;

    /** 审批状态 */
    private String auditStatus;

    /** 审批结果 */
    private String auditResult;

    /** 审批日期 */
    private Date auditDate;

    /** 创建日期 */
    private Date auditCreate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getAuditCreate() {
        return auditCreate;
    }

    public void setAuditCreate(Date auditCreate) {
        this.auditCreate = auditCreate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("auditId", getAuditId())
                .append("dataId", getDataId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("auditStatus", getAuditStatus())
                .append("auditResult", getAuditResult())
                .append("auditDate", getAuditDate())
                .append("auditCreate", getAuditCreate())
                .toString();
    }

}
