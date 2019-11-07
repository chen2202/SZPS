package com.szps.web.domain.check;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 点检内容对象 PLANT_CHECK_CONTENT
 *
 * @author HJR
 * @date 2019-10-30
 */
public class PlantCheckContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统流水号 */
    private Long contentSid;

    /** 污水厂代码 */
    @Excel(name = "污水厂代码")
    private String plantId;

    /** 点检ID */
    @Excel(name = "点检ID")
    private String checkId;

    /** 点检内容 */
    @Excel(name = "点检内容")
    private String checkName;

    /** 创建者 */
    @Excel(name = "创建者")
    private String contentCreateuser;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date contentCreatetime;

    public void setContentSid(Long contentSid)
    {
        this.contentSid = contentSid;
    }

    public Long getContentSid()
    {
        return contentSid;
    }
    public void setPlantId(String plantId)
    {
        this.plantId = plantId;
    }

    public String getPlantId()
    {
        return plantId;
    }
    public void setCheckId(String checkId)
    {
        this.checkId = checkId;
    }

    public String getCheckId()
    {
        return checkId;
    }
    public void setCheckName(String checkName)
    {
        this.checkName = checkName;
    }

    public String getCheckName()
    {
        return checkName;
    }
    public void setContentCreateuser(String contentCreateuser)
    {
        this.contentCreateuser = contentCreateuser;
    }

    public String getContentCreateuser()
    {
        return contentCreateuser;
    }
    public void setContentCreatetime(Date contentCreatetime)
    {
        this.contentCreatetime = contentCreatetime;
    }

    public Date getContentCreatetime()
    {
        return contentCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contentSid", getContentSid())
            .append("plantId", getPlantId())
            .append("checkId", getCheckId())
            .append("checkName", getCheckName())
            .append("contentCreateuser", getContentCreateuser())
            .append("contentCreatetime", getContentCreatetime())
            .toString();
    }
}
