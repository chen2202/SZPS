package com.szps.web.domain.event;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 污水厂事件对象 EVENT_SUBMIT
 *
 * @author HJR
 * @date 2019-10-25
 */
public class EventSubmit extends BaseEntity {
    private static final long serialVersionUID = 1L;

     public EventSubmit(){}




    public EventSubmit(String eventName, String eventPlace, Date eventTime, String eventContent, String eventAttribute, String eventCreateuser, Date eventCreatetime, String eventStatus) {
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.eventTime = eventTime;
        this.eventContent = eventContent;
        this.eventAttribute = eventAttribute;
        this.eventCreateuser = eventCreateuser;
        this.eventCreatetime = eventCreatetime;
        this.eventStatus = eventStatus;
    }

    /**
     * 事件编号
     */
    @Excel(name = "事件编号")
    private Integer eventSid;

    /**
     * 事件名称
     */
    @Excel(name = "事件名称")
    private String eventName;

    /**
     * 事件地点
     */
    @Excel(name = "事件地点")
    private String eventPlace;

    /**
     * 事件时间
     */
    @Excel(name = "事件时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime;

    /**
     * 事件内容
     */
    @Excel(name = "事件内容")
    private String eventContent;

    /**
     * 事件属性
     */
    @Excel(name = "事件属性")
    private String eventAttribute;

    /**
     * 上传者
     */
    @Excel(name = "上传者")
    private String eventCreateuser;

    /**
     * 上传时间
     */
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date eventCreatetime;

    /**
     * 标记
     */
    @Excel(name = "标记")
    private String eventStatus;


    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }


    public void setEventSid(Integer eventSid) {
        this.eventSid = eventSid;
    }

    public Integer getEventSid() {
        return eventSid;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventAttribute(String eventAttribute) {
        this.eventAttribute = eventAttribute;
    }

    public String getEventAttribute() {
        return eventAttribute;
    }

    public void setEventCreateuser(String eventCreateuser) {
        this.eventCreateuser = eventCreateuser;
    }

    public String getEventCreateuser() {
        return eventCreateuser;
    }

    public void setEventCreatetime(Date eventCreatetime) {
        this.eventCreatetime = eventCreatetime;
    }

    public Date getEventCreatetime() {
        return eventCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("eventSid", getEventSid())
                .append("eventName", getEventName())
                .append("eventPlace", getEventPlace())
                .append("eventTime", getEventTime())
                .append("eventContent", getEventContent())
                .append("eventAttribute", getEventAttribute())
                .append("eventCreateuser", getEventCreateuser())
                .append("eventCreatetime", getEventCreatetime())
                .append("eventStatus", getEventStatus())
                .toString();
    }
}
