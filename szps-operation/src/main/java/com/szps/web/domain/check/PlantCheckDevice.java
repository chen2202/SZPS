package com.szps.web.domain.check;

import com.szps.common.annotation.Excel;
import com.szps.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 点检设备资料对象 PLANT_CHECK_DEVICE
 *
 * @author HJR
 * @date 2019-10-30
 */
public class PlantCheckDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统流水号 */
    private Long deviceSid;

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

    /** 创建者 */
    @Excel(name = "创建者")
    private String deviceCreateuser;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date deviceCreatetime;

    public void setDeviceSid(Long deviceSid)
    {
        this.deviceSid = deviceSid;
    }

    public Long getDeviceSid()
    {
        return deviceSid;
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
    public void setDeviceCreateuser(String deviceCreateuser)
    {
        this.deviceCreateuser = deviceCreateuser;
    }

    public String getDeviceCreateuser()
    {
        return deviceCreateuser;
    }
    public void setDeviceCreatetime(Date deviceCreatetime)
    {
        this.deviceCreatetime = deviceCreatetime;
    }

    public Date getDeviceCreatetime()
    {
        return deviceCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceSid", getDeviceSid())
            .append("plantId", getPlantId())
            .append("plantName", getPlantName())
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("checkId", getCheckId())
            .append("deviceCreateuser", getDeviceCreateuser())
            .append("deviceCreatetime", getDeviceCreatetime())
            .toString();
    }
}
