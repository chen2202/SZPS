package com.szps.web.domain.dm;

import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 污水处理费表
 *
 * @author vic
 *
 */
public class DmCost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long costId;

    /** 文件名 */
    private String costName;

    /** 文件路径 */
    private String costPath;

    /** 区域 */
    private String costArea;

    /** 创建者 */
    private String costCreate;

    /** 创建日期 */
    private Date costDate;

    /** 文件来源 */
    private String costSource;

    /** 文件编码 */
    private String costCode;

    public Long getCostId() {
        return costId;
    }

    public void setCostId(Long costId) {
        this.costId = costId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostPath() {
        return costPath;
    }

    public void setCostPath(String costPath) {
        this.costPath = costPath;
    }

    public String getCostArea() {
        return costArea;
    }

    public void setCostArea(String costArea) {
        this.costArea = costArea;
    }

    public String getCostCreate() {
        return costCreate;
    }

    public void setCostCreate(String costCreate) {
        this.costCreate = costCreate;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    public String getCostSource() {
        return costSource;
    }

    public void setCostSource(String costSource) {
        this.costSource = costSource;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("costId", getCostId())
                .append("costName", getCostName())
                .append("costPath", getCostPath())
                .append("costArea", getCostArea())
                .append("costCreate", getCostCreate())
                .append("costDate", getCostDate())
                .append("costSource", getCostSource())
                .append("costCode", getCostCode())
                .toString();
    }
}
