package com.szps.web.domain.check;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    /** 系统流水号 */
    private Long systemId;

    /** 污水厂代码 */
    @Excel(name = "污水厂代码")
    private String plantId;

    /** 污水厂名称 */
    @Excel(name = "污水厂名称")
    private String plantName;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 点检ID */
    @Excel(name = "点检ID")
    private String checkId;

    /** 简单故障处理记录 */
    @Excel(name = "简单故障处理记录")
    private String sloveRecord;

    /** 巡检日期 */
    @Excel(name = "巡检日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date checkDate;

    public PlantCheckRecord() {

    }

    /** 创建者 */
    @Excel(name = "创建者")
    private String systemCreateuser;

    /** 创建日期 */
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date systemCreatetime;

    public PlantCheckRecord(String plantId, String plantName, String deviceId, String deviceName, String checkId, String sloveRecord, Date checkDate, String systemCreateuser, Date systemCreatetime) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.checkId = checkId;
        this.sloveRecord = sloveRecord;
        this.checkDate = checkDate;
        this.systemCreateuser = systemCreateuser;
        this.systemCreatetime = systemCreatetime;
    }

    public void setSystemId(Long systemId)
    {
        this.systemId = systemId;
    }

    public Long getSystemId()
    {
        return systemId;
    }
    public void setPlantId(String plantId)
    {
        this.plantId = plantId;
    }

    public String getPlantId()
    {
        return plantId;
    }
    public void setPlantName(String plantName)
    {
        this.plantName = plantName;
    }

    public String getPlantName()
    {
        return plantName;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setCheckId(String checkId)
    {
        this.checkId = checkId;
    }

    public String getCheckId()
    {
        return checkId;
    }
    public void setSloveRecord(String sloveRecord)
    {
        this.sloveRecord = sloveRecord;
    }

    public String getSloveRecord()
    {
        return sloveRecord;
    }
    public void setCheckDate(Date checkDate)
    {
        this.checkDate = checkDate;
    }

    public Date getCheckDate()
    {
        return checkDate;
    }
    public void setSystemCreateuser(String systemCreateuser)
    {
        this.systemCreateuser = systemCreateuser;
    }

    public String getSystemCreateuser()
    {
        return systemCreateuser;
    }
    public void setSystemCreatetime(Date systemCreatetime)
    {
        this.systemCreatetime = systemCreatetime;
    }

    public Date getSystemCreatetime()
    {
        return systemCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("systemId", getSystemId())
            .append("plantId", getPlantId())
            .append("plantName", getPlantName())
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("checkId", getCheckId())
            .append("sloveRecord", getSloveRecord())
            .append("checkDate", getCheckDate())
            .append("systemCreateuser", getSystemCreateuser())
            .append("systemCreatetime", getSystemCreatetime())
            .toString();
    }
}
