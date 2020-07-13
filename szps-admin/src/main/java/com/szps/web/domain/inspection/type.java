package com.szps.web.domain.inspection;

import com.szps.system.domain.SysDept;

import java.util.List;

public class type {

    private String typeName;

    private List<SysDept> sysDepts;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<SysDept> getSysDepts() {
        return sysDepts;
    }

    public void setSysDepts(List<SysDept> sysDepts) {
        this.sysDepts = sysDepts;
    }

    @Override
    public String toString() {
        return "type{" +
                "typeName='" + typeName + '\'' +
                ", sysDepts=" + sysDepts +
                '}';
    }
}


