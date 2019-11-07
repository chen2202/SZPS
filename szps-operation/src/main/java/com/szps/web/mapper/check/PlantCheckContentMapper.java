package com.szps.web.mapper.check;

import com.szps.system.domain.SysUser;
import com.szps.web.domain.check.PlantCheckContent;
import com.szps.web.domain.check.PlantCheckDevice;

import java.util.List;

/**
 * 点检内容Mapper接口
 *
 * @author HJR
 * @date 2019-10-30
 */
public interface PlantCheckContentMapper
{
    /**
     * 查询点检内容
     *
     * @param contentSid 点检内容ID
     * @return 点检内容
     */
    public PlantCheckContent selectPlantCheckContentById(Long contentSid);

    /**
     * 查询点检内容列表
     *
     * @param plantCheckContent 点检内容
     * @return 点检内容集合
     */
    public List<PlantCheckContent> selectPlantCheckContentList(PlantCheckContent plantCheckContent);

    /**
     * 新增点检内容
     *
     * @param plantCheckContent 点检内容
     * @return 结果
     */
    public int insertPlantCheckContent(PlantCheckContent plantCheckContent);

    /**
     * 修改点检内容
     *
     * @param plantCheckContent 点检内容
     * @return 结果
     */
    public int updatePlantCheckContent(PlantCheckContent plantCheckContent);

    /**
     * 删除点检内容
     *
     * @param contentSid 点检内容ID
     * @return 结果
     */
    public int deletePlantCheckContentById(Long contentSid);

    /**
     * 批量删除点检内容
     *
     * @param contentSids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlantCheckContentByIds(String[] contentSids);


    public List<PlantCheckDevice> getALL(SysUser user);
}
