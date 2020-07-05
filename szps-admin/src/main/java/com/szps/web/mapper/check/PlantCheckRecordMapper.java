package com.szps.web.mapper.check;

import com.szps.web.domain.check.CheckPicture;
import com.szps.web.domain.check.PlantCheckRecord;

import java.util.List;

/**
 * 污水厂巡检Mapper接口
 *
 * @author HJR
 * @date 2019-11-05
 */
public interface PlantCheckRecordMapper
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
     * 删除巡检管理
     *
     * @param checkId 巡检管理ID
     * @return 结果
     */
    public int deleteCheckManagerById(Long checkId);

    /**
     * 批量删除巡检管理
     *
     * @param checkIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCheckManagerByIds(String[] checkIds);


    /**
     * 获取图片
     * @param checkPicture
     * @return
     */
    public  List<CheckPicture> getCheckPictures(CheckPicture checkPicture);

}
