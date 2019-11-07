package com.szps.web.service.check;

import com.szps.system.domain.SysUser;
import com.szps.web.domain.check.PlantCheckContent;
import com.szps.web.domain.check.PlantCheckDevice;

import java.util.List;

/**
 * 点检内容Service接口
 *
 * @author HJR
 * @date 2019-10-30
 */
public interface IPlantCheckContentService
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
     * 批量删除点检内容
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlantCheckContentByIds(String ids);

    /**
     * 删除点检内容信息
     *
     * @param contentSid 点检内容ID
     * @return 结果
     */
    public int deletePlantCheckContentById(Long contentSid);


    /**
     *
     * 查询污水厂代码和点检ID
     */

    public List<PlantCheckDevice> getALL(SysUser user);

}
