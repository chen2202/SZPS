package com.szps.web.domain.check;


/**
 * 突发事件图片
 */
public class CheckPicture {

    private int eventPictureSid;
    private int eventSd;
    private String eventPictureUrl;

    @Override
    public String toString() {
        return "CheckPicture{" +
                "eventPictureSid=" + eventPictureSid +
                ", eventSd=" + eventSd +
                ", eventPictureUrl='" + eventPictureUrl + '\'' +
                '}';
    }

    public CheckPicture(int eventPictureSid, int eventSd, String eventPictureUrl) {
        this.eventPictureSid = eventPictureSid;
        this.eventSd = eventSd;
        this.eventPictureUrl = eventPictureUrl;
    }

    public int getEventPictureSid() {
        return eventPictureSid;
    }

    public void setEventPictureSid(int eventPictureSid) {
        this.eventPictureSid = eventPictureSid;
    }

    public int getEventSd() {
        return eventSd;
    }

    public void setEventSd(int eventSd) {
        this.eventSd = eventSd;
    }

    public String getEventPictureUrl() {
        return eventPictureUrl;
    }

    public void setEventPictureUrl(String eventPictureUrl) {
        this.eventPictureUrl = eventPictureUrl;
    }
}
