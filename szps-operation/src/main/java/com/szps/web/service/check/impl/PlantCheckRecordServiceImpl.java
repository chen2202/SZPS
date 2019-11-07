package com.szps.web.service.check.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import com.szps.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.check.PlantCheckRecordMapper;
import com.szps.web.domain.check.PlantCheckRecord;
import com.szps.web.service.check.IPlantCheckRecordService;


/**
 * 污水厂巡检Service业务层处理
 *
 * @author HJR
 * @date 2019-11-05
 */
@Service
public class PlantCheckRecordServiceImpl implements IPlantCheckRecordService {
    @Autowired
    private PlantCheckRecordMapper plantCheckRecordMapper;

    /**
     * 查询污水厂巡检
     *
     * @param systemId 污水厂巡检ID
     * @return 污水厂巡检
     */
    @Override
    public PlantCheckRecord selectPlantCheckRecordById(Long systemId) {
        return plantCheckRecordMapper.selectPlantCheckRecordById(systemId);
    }

    /**
     * 查询污水厂巡检列表
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 污水厂巡检
     */
    @Override
    public List<PlantCheckRecord> selectPlantCheckRecordList(PlantCheckRecord plantCheckRecord) {
        return plantCheckRecordMapper.selectPlantCheckRecordList(plantCheckRecord);
    }

    /**
     * 新增污水厂巡检
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 结果
     */
    @Override
    public int insertPlantCheckRecord(PlantCheckRecord plantCheckRecord) {
        return plantCheckRecordMapper.insertPlantCheckRecord(plantCheckRecord);
    }

    /**
     * 修改污水厂巡检
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 结果
     */
    @Override
    public int updatePlantCheckRecord(PlantCheckRecord plantCheckRecord) {
        return plantCheckRecordMapper.updatePlantCheckRecord(plantCheckRecord);
    }

    /**
     * 删除污水厂巡检对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckRecordByIds(String ids) {
        return plantCheckRecordMapper.deletePlantCheckRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除污水厂巡检信息
     *
     * @param systemId 污水厂巡检ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckRecordById(Long systemId) {
        return plantCheckRecordMapper.deletePlantCheckRecordById(systemId);
    }

    /**
     * 根据条件查询污水厂集合
     */
    @Override
    public List<PlantCheckRecord> selectPlantCheckRecordList2(SysUser user) {
        return plantCheckRecordMapper.selectPlantCheckRecordList2(user);
    }


}
