package com.szps.web.domain.event;

import java.util.List;

public class EventLists {

    private EventSubmit eventSubmit;

    private List<EventPicture> list;

    public EventSubmit getEventSubmit() {
        return eventSubmit;
    }

    public void setEventSubmit(EventSubmit eventSubmit) {
        this.eventSubmit = eventSubmit;
    }

    public List<EventPicture> getList() {
        return list;
    }

    public void setList(List<EventPicture> list) {
        this.list = list;
    }
}
