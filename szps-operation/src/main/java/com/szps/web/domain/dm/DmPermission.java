package com.szps.web.domain.dm;

import com.szps.common.core.domain.BaseEntity;
import com.szps.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 资料权限表
 *
 * @author  vic
 */
public class DmPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private long perId;

    private long dataId;

    private long userId;

    private Date perDate;

    private String perStatus;

    public long getPerId() {
        return perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getPerDate() {
        return perDate;
    }

    public void setPerDate(Date perDate) {
        this.perDate = perDate;
    }

    public String getPerStatus() {
        return perStatus;
    }

    public void setPerStatus(String perStatus) {
        this.perStatus = perStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("perId", getPerId())
                .append("dataId", getDataId())
                .append("userId", getUserId())
                .append("perDate", getPerDate())
                .append("perStatus", getPerStatus())
                .toString();
    }
}
