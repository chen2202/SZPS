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
    private PlantCheckRecordMapper checkManagerMapper;

    /**
     * 查询巡检管理
     *
     * @param checkId 巡检管理ID
     * @return 巡检管理
     */
    @Override
    public PlantCheckRecord selectCheckManagerById(Long checkId)
    {
        return checkManagerMapper.selectCheckManagerById(checkId);
    }

    /**
     * 查询巡检管理列表
     *
     * @param checkManager 巡检管理
     * @return 巡检管理
     */
    @Override
    public List<PlantCheckRecord> selectCheckManagerList(PlantCheckRecord checkManager)
    {
        return checkManagerMapper.selectCheckManagerList(checkManager);
    }

    /**
     * 新增巡检管理
     *
     * @param checkManager 巡检管理
     * @return 结果
     */
    @Override
    public int insertCheckManager(PlantCheckRecord checkManager)
    {
        return checkManagerMapper.insertCheckManager(checkManager);
    }

    /**
     * 修改巡检管理
     *
     * @param checkManager 巡检管理
     * @return 结果
     */
    @Override
    public int updateCheckManager(PlantCheckRecord checkManager)
    {
        return checkManagerMapper.updateCheckManager(checkManager);
    }

    /**
     * 删除巡检管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCheckManagerByIds(String ids)
    {
        return checkManagerMapper.deleteCheckManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检管理信息
     *
     * @param checkId 巡检管理ID
     * @return 结果
     */
    @Override
    public int deleteCheckManagerById(Long checkId)
    {
        return checkManagerMapper.deleteCheckManagerById(checkId);
    }


}
