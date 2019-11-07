package com.szps.web.domain.dm;

import com.szps.common.core.domain.BaseEntity;
import com.szps.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class DmUDP extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private long perId;

    private long dataId;

    private long userId;

    private Date perDate;

    private String perStatus;

    private String perView;

    private String perDownload;

    private DmData data;

    private SysUser user;

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

    public String getPerView() {
        return perView;
    }

    public void setPerView(String perView) {
        this.perView = perView;
    }

    public String getPerDownload() {
        return perDownload;
    }

    public void setPerDownload(String perDownload) {
        this.perDownload = perDownload;
    }

    public DmData getData() {
        if(data==null){
            data = new DmData();
        }
        return data;
    }

    public void setData(DmData data) {
        this.data = data;
    }

    public SysUser getUser() {
        if(user==null){
            user = new SysUser();
        }
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public void setPermission(DmPermission permission){
        perId = permission.getPerId();
        dataId = permission.getDataId();
        userId = permission.getUserId();
        perDate = permission.getPerDate();
        perStatus = permission.getPerStatus();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("perId", getPerId())
                .append("dataId", getDataId())
                .append("userId", getUserId())
                .append("perDate", getPerDate())
                .append("perStatus", getPerStatus())
                .append("perView", getPerView())
                .append("perDownload", getPerDownload())
                .append("data", getData())
                .append("user", getUser())
                .toString();
    }

}
