package com.szps.web.service.check;

import com.szps.web.domain.check.PlantCheckDevice;
import java.util.List;

/**
 * 点检设备资料Service接口
 *
 * @author HJR
 * @date 2019-10-30
 */
public interface IPlantCheckDeviceService
{
    /**
     * 查询点检设备资料
     *
     * @param deviceSid 点检设备资料ID
     * @return 点检设备资料
     */
    public PlantCheckDevice selectPlantCheckDeviceById(Long deviceSid);

    /**
     * 查询点检设备资料列表
     *
     * @param plantCheckDevice 点检设备资料
     * @return 点检设备资料集合
     */
    public List<PlantCheckDevice> selectPlantCheckDeviceList(PlantCheckDevice plantCheckDevice);

    /**
     * 新增点检设备资料
     *
     * @param plantCheckDevice 点检设备资料
     * @return 结果
     */
    public int insertPlantCheckDevice(PlantCheckDevice plantCheckDevice);

    /**
     * 修改点检设备资料
     *
     * @param plantCheckDevice 点检设备资料
     * @return 结果
     */
    public int updatePlantCheckDevice(PlantCheckDevice plantCheckDevice);

    /**
     * 批量删除点检设备资料
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlantCheckDeviceByIds(String ids);

    /**
     * 删除点检设备资料信息
     *
     * @param deviceSid 点检设备资料ID
     * @return 结果
     */
    public int deletePlantCheckDeviceById(Long deviceSid);
}
