package com.szps.web.domain.supervise;

import java.util.List;

public class TBALL {
    private TbTask tbTask;
    private List<TbPicture> pictureList;

    public TbTask getTbTask() {
        return tbTask;
    }

    public void setTbTask(TbTask tbTask) {
        this.tbTask = tbTask;
    }

    public List<TbPicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<TbPicture> pictureList) {
        this.pictureList = pictureList;
    }
}
