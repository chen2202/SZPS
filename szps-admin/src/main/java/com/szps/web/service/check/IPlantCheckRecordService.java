package com.szps.web.service.check;

import com.szps.web.domain.check.CheckPicture;
import com.szps.web.domain.check.PlantCheckRecord;

import java.util.List;

/**
 * 污水厂巡检Service接口
 *
 * @author HJR
 * @date 2019-11-05
 */
public interface IPlantCheckRecordService
{
    /**
     * 查询巡检管理
     *
     * @param checkId 巡检管理ID
     * @return 巡检管理
     */
    public PlantCheckRecord selectCheckManagerById(Long checkId);

    /**
     * 查询巡检管理列表
     *
     * @param checkManager 巡检管理
     * @return 巡检管理集合
     */
    public List<PlantCheckRecord> selectCheckManagerList(PlantCheckRecord checkManager);

    /**
     * 新增巡检管理
     *
     * @param checkManager 巡检管理
     * @return 结果
     */
    public int insertCheckManager(PlantCheckRecord checkManager);

    /**
     * 修改巡检管理
     *
     * @param checkManager 巡检管理
     * @return 结果
     */
    public int updateCheckManager(PlantCheckRecord checkManager);

    /**
     * 批量删除巡检管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCheckManagerByIds(String ids);

    /**
     * 删除巡检管理信息
     *
     * @param checkId 巡检管理ID
     * @return 结果
     */
    public int deleteCheckManagerById(Long checkId);

    /**
     * 获取图片
     * @param checkPicture
     * @return
     */
    public  List<CheckPicture> getCheckPictures(CheckPicture checkPicture);


    /**
     * 插入图片
     * @param checkPicture
     * @return
     */
    public  int insertPicture(CheckPicture checkPicture);

}
