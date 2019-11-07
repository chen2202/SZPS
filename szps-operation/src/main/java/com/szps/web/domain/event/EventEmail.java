package com.szps.web.domain.event;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 负责人邮箱信息对象 EVENT_EMAIL
 *
 * @author HJR
 * @date 2019-11-05
 */
public class EventEmail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统流水号 */
    private Long sid;

    /** 事件属性 */
    @Excel(name = "事件属性")
    private String eventAttribute;

    /** 负责人邮箱 */
    @Excel(name = "负责人邮箱")
    private String eventEmail;

    public void setSid(Long sid)
    {
        this.sid = sid;
    }

    public Long getSid()
    {
        return sid;
    }
    public void setEventAttribute(String eventAttribute)
    {
        this.eventAttribute = eventAttribute;
    }

    public String getEventAttribute()
    {
        return eventAttribute;
    }
    public void setEventEmail(String eventEmail)
    {
        this.eventEmail = eventEmail;
    }

    public String getEventEmail()
    {
        return eventEmail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("eventAttribute", getEventAttribute())
            .append("eventEmail", getEventEmail())
            .toString();
    }
}
