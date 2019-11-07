package com.szps.web.mapper.check;

import com.szps.system.domain.SysUser;
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
     * 查询污水厂巡检
     *
     * @param systemId 污水厂巡检ID
     * @return 污水厂巡检
     */
    public PlantCheckRecord selectPlantCheckRecordById(Long systemId);

    /**
     * 查询污水厂巡检列表
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 污水厂巡检集合
     */
    public List<PlantCheckRecord> selectPlantCheckRecordList(PlantCheckRecord plantCheckRecord);

    /**
     * 新增污水厂巡检
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 结果
     */
    public int insertPlantCheckRecord(PlantCheckRecord plantCheckRecord);

    /**
     * 修改污水厂巡检
     *
     * @param plantCheckRecord 污水厂巡检
     * @return 结果
     */
    public int updatePlantCheckRecord(PlantCheckRecord plantCheckRecord);

    /**
     * 删除污水厂巡检
     *
     * @param systemId 污水厂巡检ID
     * @return 结果
     */
    public int deletePlantCheckRecordById(Long systemId);

    /**
     * 批量删除污水厂巡检
     *
     * @param systemIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePlantCheckRecordByIds(String[] systemIds);


    /**
     *  根据条件查询污水厂集合
     */

    public List<PlantCheckRecord> selectPlantCheckRecordList2(SysUser user);

}
