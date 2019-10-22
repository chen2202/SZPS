package com.szps.web.domain.dm;


import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 操作日志表
 *
 * @author  vic
 */
public class DmLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private Long logId;

    /** 录入时间 */
    private Date logDate;

    /** 日志内容 */
    private String logContent;

    /** 用户 */
    private String userAccount;

    /** 登陆IP */
    private String logIp;

    /** 操作结果 */
    private String logResult;

    /** 删除标志 */
    private String logFlag;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public String getLogFlag() {
        return logFlag;
    }

    public void setLogFlag(String logFlag) {
        this.logFlag = logFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("logId", getLogId())
                .append("logDate", getLogDate())
                .append("logContent", getLogContent())
                .append("userAccount", getUserAccount())
                .append("logIp", getLogIp())
                .append("logResult", getLogResult())
                .append("logFlag", getLogFlag())
                .toString();
    }
}
