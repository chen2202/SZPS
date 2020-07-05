package com.szps.web.domain.check;


/**
 * 巡检图片
 */
public class CheckPicture {

    private String checkSid;

    private String checkPictureName;

    private String checkPictureUrl;

    public String getCheckSid() {
        return checkSid;
    }

    public void setCheckSid(String checkSid) {
        this.checkSid = checkSid;
    }

    public String getCheckPictureName() {
        return checkPictureName;
    }

    public void setCheckPictureName(String checkPictureName) {
        this.checkPictureName = checkPictureName;
    }

    public String getGetCheckPictureUrl() {
        return checkPictureUrl;
    }

    public void setGetCheckPictureUrl(String getCheckPictureUrl) {
        this.checkPictureUrl = getCheckPictureUrl;
    }


    @Override
    public String toString() {
        return "CheckPicture{" +
                "checkSid='" + checkSid + '\'' +
                ", checkPictureName='" + checkPictureName + '\'' +
                ", getCheckPictureUrl='" + checkPictureUrl + '\'' +
                '}';
    }
}
