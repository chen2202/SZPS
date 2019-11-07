package com.szps.web.service.check.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.check.PlantCheckDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.check.PlantCheckContentMapper;
import com.szps.web.domain.check.PlantCheckContent;
import com.szps.web.service.check.IPlantCheckContentService;


/**
 * 点检内容Service业务层处理
 *
 * @author HJR
 * @date 2019-10-30
 */
@Service
public class PlantCheckContentServiceImpl implements IPlantCheckContentService
{
    @Autowired
    private PlantCheckContentMapper plantCheckContentMapper;

    /**
     * 查询点检内容
     *
     * @param contentSid 点检内容ID
     * @return 点检内容
     */
    @Override
    public PlantCheckContent selectPlantCheckContentById(Long contentSid)
    {
        return plantCheckContentMapper.selectPlantCheckContentById(contentSid);
    }

    /**
     * 查询点检内容列表
     *
     * @param plantCheckContent 点检内容
     * @return 点检内容
     */
    @Override
    public List<PlantCheckContent> selectPlantCheckContentList(PlantCheckContent plantCheckContent)
    {
        return plantCheckContentMapper.selectPlantCheckContentList(plantCheckContent);
    }

    /**
     * 新增点检内容
     *
     * @param plantCheckContent 点检内容
     * @return 结果
     */
    @Override
    public int insertPlantCheckContent(PlantCheckContent plantCheckContent)
    {
        return plantCheckContentMapper.insertPlantCheckContent(plantCheckContent);
    }

    /**
     * 修改点检内容
     *
     * @param plantCheckContent 点检内容
     * @return 结果
     */
    @Override
    public int updatePlantCheckContent(PlantCheckContent plantCheckContent)
    {
        return plantCheckContentMapper.updatePlantCheckContent(plantCheckContent);
    }

    /**
     * 删除点检内容对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckContentByIds(String ids)
    {
        return plantCheckContentMapper.deletePlantCheckContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除点检内容信息
     *
     * @param contentSid 点检内容ID
     * @return 结果
     */
    @Override
    public int deletePlantCheckContentById(Long contentSid)
    {
        return plantCheckContentMapper.deletePlantCheckContentById(contentSid);
    }


    /**
     *
     * 查询污水厂代码和点检ID
     */

    public List<PlantCheckDevice> getALL(SysUser user){
        return plantCheckContentMapper.getALL(user);
    }
}
