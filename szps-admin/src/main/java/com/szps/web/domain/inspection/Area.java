package com.szps.web.domain.inspection;

import java.util.List;

public class Area {
    private String area;

    private List<type> type;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<com.szps.web.domain.inspection.type> getType() {
        return type;
    }

    public void setType(List<com.szps.web.domain.inspection.type> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Area{" +
                "area='" + area + '\'' +
                ", type=" + type +
                '}';
    }
}
