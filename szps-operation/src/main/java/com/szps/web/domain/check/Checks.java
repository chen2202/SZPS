package com.szps.web.domain.check;

import java.util.List;

public class Checks {

    private PlantCheckRecord plantCheckRecord;

    private List<CheckPicture> list;

    public PlantCheckRecord getPlantCheckRecord() {
        return plantCheckRecord;
    }

    public void setPlantCheckRecord(PlantCheckRecord plantCheckRecord) {
        this.plantCheckRecord = plantCheckRecord;
    }

    public List<CheckPicture> getList() {
        return list;
    }

    public void setList(List<CheckPicture> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Check{" +
                "plantCheckRecord=" + plantCheckRecord +
                ", list=" + list +
                '}';
    }
}
