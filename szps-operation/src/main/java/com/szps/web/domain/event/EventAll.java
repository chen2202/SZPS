package com.szps.web.domain.event;

import com.szps.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EventAll extends EventSubmit {
    @Excel(name = "邮箱")
    private String eventEmail;


    public void setEventEmail(String eventEmail){
        this.eventEmail=eventEmail;
    }

    public String getEventEmail(){
        return eventEmail;
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
                .append("eventEmail",getEventEmail())
                .toString();
    }

}
