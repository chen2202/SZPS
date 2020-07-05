package com.szps.web.domain.check;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 污水厂巡检对象 PLANT_CHECK_RECORD
 *
 * @author HJR
 * @date 2019-11-05
 */
public class PlantCheckRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检编号 */
    private String checkId;

    /** 巡检地区 */
    @Excel(name = "巡检地区")
    private String checkArea;

    /** 巡检设施类型 */
    @Excel(name = "巡检设施类型")
    private String checkType;

    /** 巡检地点 */
    @Excel(name = "巡检地点")
    private String checkPlace;

    /** 上报时间 */
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkSubmitTime;

    /** 巡检人 */
    @Excel(name = "巡检人")
    private String checkUser;

    /** 巡检描述 */
    @Excel(name = "巡检描述")
    private String checkDetail;

    public void setCheckId(String checkId)
    {
        this.checkId = checkId;
    }

    public String getCheckId()
    {
        return checkId;
    }
    public void setCheckArea(String checkArea)
    {
        this.checkArea = checkArea;
    }

    public String getCheckArea()
    {
        return checkArea;
    }
    public void setCheckType(String checkType)
    {
        this.checkType = checkType;
    }

    public String getCheckType()
    {
        return checkType;
    }
    public void setCheckPlace(String checkPlace)
    {
        this.checkPlace = checkPlace;
    }

    public String getCheckPlace()
    {
        return checkPlace;
    }
    public void setCheckSubmitTime(Date checkSubmitTime)
    {
        this.checkSubmitTime = checkSubmitTime;
    }

    public Date getCheckSubmitTime()
    {
        return checkSubmitTime;
    }
    public void setCheckUser(String checkUser)
    {
        this.checkUser = checkUser;
    }

    public String getCheckUser()
    {
        return checkUser;
    }
    public void setCheckDetail(String checkDetail)
    {
        this.checkDetail = checkDetail;
    }

    public String getCheckDetail()
    {
        return checkDetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("checkId", getCheckId())
                .append("checkArea", getCheckArea())
                .append("checkType", getCheckType())
                .append("checkPlace", getCheckPlace())
                .append("checkSubmitTime", getCheckSubmitTime())
                .append("checkUser", getCheckUser())
                .append("checkDetail", getCheckDetail())
                .toString();
    }
}
