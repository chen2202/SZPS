package com.szps.web.service.check.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.check.PlantCheckDeviceMapper;
import com.szps.web.domain.check.PlantCheckDevice;
import com.szps.web.service.check.IPlantCheckDeviceService;


/**
 * 点检设备资料Service业务层处理
 *
 * @author HJR
 * @date 2019-10-30
 */
@Service
public class PlantCheckDeviceServiceImpl implements IPlantCheckDeviceService
{
    @Autowired
    private PlantCheckDeviceMapper plantCheckDeviceMapper;

    /**
     * 查询点检设备资料
     *
     * @param deviceSid 点检设备资料ID
     * @return 点检设备资料
     */
    @Override
    public PlantCheckDevice selectPlantCheckDeviceById(Long deviceSid)
    {
        return plantCheckDeviceMapper.selectPlantCheckDeviceById(deviceSid);
    }

    /**
     * 查询点检设备资料列表
     *
     * @param plantCheckDevice 点检设备资料
     * @return 点检设备资料
     */
    @Override
    public List<PlantCheckDevice> selectPlantCheckDeviceList(PlantCheckDevice plantCheckDevice)
    {
        return plantCheckDeviceMapper.selectPlantCheckDeviceList(plantCheckDevice);
    }

    /**
     * 新增点检设备资料
     *
     * @param plantCheckDevice 点检设备资料
     * @return 结果
     */
    @Override
    public int insertPlantCheckDevice(PlantCheckDevice plantCheckDevice)
    {
        return plantCheckDeviceMapper.insertPlantCheckDevice(plantCheckDevice);
    }

    /**
     * 修改点检设备资料
     *
     * @param plantCheckDevice 点检设备资料
     * @return 结果
     */
    @Override
    public int updatePlantCheckDevice(PlantCheckDevice plantCheckDevice)
    {
        return plantCheckDeviceMapper.updatePlantCheckDevice(plantCheckDevice);
    }

    /**
     * 删除点检设备资料对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckDeviceByIds(String ids)
    {
        return plantCheckDeviceMapper.deletePlantCheckDeviceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除点检设备资料信息
     *
     * @param deviceSid 点检设备资料ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckDeviceById(Long deviceSid)
    {
        return plantCheckDeviceMapper.deletePlantCheckDeviceById(deviceSid);
    }
}
