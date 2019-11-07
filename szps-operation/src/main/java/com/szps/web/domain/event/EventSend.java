package com.szps.web.domain.event;


import com.szps.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 属性邮箱对应表 EVENT_EMAIL
 *
 * @author HJR
 * @date 2019-10-25
 */
public class EventSend  {



    @Excel(name = "邮箱")
    private String eventEmail;

    /** 事件属性 */
    @Excel(name = "事件属性")
    private String eventAttribute;

    public void setEventEmail(String eventEmail){
        this.eventEmail=eventEmail;
    }

    public String getEventEmail(){
        return eventEmail;
    }

    public void setEventAttribute(String eventAttribute)
    {
        this.eventAttribute = eventAttribute;
    }

    public String getEventAttribute()
    {
        return eventAttribute;
    }


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("eventAttribute", getEventAttribute())
                .append("eventEmail",getEventEmail())
                .toString();
    }

}
