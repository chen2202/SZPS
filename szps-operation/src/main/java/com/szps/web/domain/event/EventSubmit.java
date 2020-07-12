package com.szps.web.domain.event;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 突发事件上传对象 event_submit
 *
 * @author HJR
 * @date 2020-06-06
 */
public class EventSubmit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件编号 */
    private String eventSid;

    /** 事件名称 */
    @Excel(name = "事件名称")
    private String eventName;

    /** 事件地点 */
    @Excel(name = "事件地点")
    private String eventPlace;

    /** 事件时间 */
    @Excel(name = "事件时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventTime;

    /** 事件内容 */
    @Excel(name = "事件内容")
    private String eventContent;

    /** 上报人 */
    @Excel(name = "上报人")
    private String eventSubmitUser;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String eventPhone;

    /** 所属单位 */
    @Excel(name = "所属单位")
    private String eventUnit;

    /** 上报时间 */
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eventSubmitTime;

    public void setEventSId(String eventSid)
    {
        this.eventSid = eventSid;
    }

    public String getEventSId()
    {
        return eventSid;
    }
    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getEventName()
    {
        return eventName;
    }
    public void setEventPlace(String eventPlace)
    {
        this.eventPlace = eventPlace;
    }

    public String getEventPlace()
    {
        return eventPlace;
    }
    public void setEventTime(Date eventTime)
    {
        this.eventTime = eventTime;
    }

    public Date getEventTime()
    {
        return eventTime;
    }
    public void setEventContent(String eventContent)
    {
        this.eventContent = eventContent;
    }

    public String getEventContent()
    {
        return eventContent;
    }
    public void setEventSubmitUser(String eventSubmitUser)
    {
        this.eventSubmitUser = eventSubmitUser;
    }

    public String getEventSubmitUser()
    {
        return eventSubmitUser;
    }
    public void setEventPhone(String eventPhone)
    {
        this.eventPhone = eventPhone;
    }

    public String getEventPhone()
    {
        return eventPhone;
    }
    public void setEventUnit(String eventUnit)
    {
        this.eventUnit = eventUnit;
    }

    public String getEventUnit()
    {
        return eventUnit;
    }
    public void setEventSubmitTime(Date eventSubmitTime)
    {
        this.eventSubmitTime = eventSubmitTime;
    }

    public Date getEventSubmitTime()
    {
        return eventSubmitTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("eventId", getEventSId())
                .append("eventName", getEventName())
                .append("eventPlace", getEventPlace())
                .append("eventTime", getEventTime())
                .append("eventContent", getEventContent())
                .append("eventSubmitUser", getEventSubmitUser())
                .append("eventPhone", getEventPhone())
                .append("eventUnit", getEventUnit())
                .append("eventSubmitTime", getEventSubmitTime())
                .toString();
    }
}
