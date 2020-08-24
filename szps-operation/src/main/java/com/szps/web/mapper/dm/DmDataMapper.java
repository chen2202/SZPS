package com.szps.web.mapper.dm;

import java.util.List;

import com.szps.web.domain.dm.DmData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 资料表 数据层
 * 
 * @author vic
 */
@Repository
public interface DmDataMapper {

    /**
     * 根据条件分页查询审批通过且还没被删除的资料列表
     *
     * @param dmData 资料信息
     * @return 资料信息集合信息
     */
    public List<DmData> selectDataList(DmData dmData);

    /**
     * 根据条件分页查询未审批的资料列表
     *
     * @param dmData 资料信息
     * @return 资料信息集合信息
     */
    public List<DmData> selectApprovalDataList(DmData dmData);

    /**
     * 根据条件分页查询审批通过的资料列表
     *
     * @param dmData 资料信息
     * @return 资料信息集合信息
     */
    public List<DmData> selectPassDataList(DmData dmData);

    /**
     * 根据条件分页查询全部被删除的资料列表(状态被修改，实际未删除)
     *
     * @param dmData 资料信息
     * @return 资料信息集合信息
     */
    public List<DmData> selectDeletedDataList(DmData dmData);


    /**
     * 通过资料ID查询资料
     *
     * @param dataId 资料ID
     * @return 用户对象信息
     */
    public DmData selectDataById(Long dataId);

    /**
     * 通过申请编号查询资料
     *
     * @param dataUuid 资料ID
     * @return 用户对象信息
     */
    public DmData selectDataByUuid(String dataUuid);

    /**
     * 批量删除资料信息(只改变状态)
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int changeDataFlagByIds(@Param("ids") Long[] ids, @Param("dataFlag") String dataFlag);

    /**
     * 批量删除资料(从回收站删除)
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteDataByIds(Long[] ids);

    /**
     * 保存资料信息
     *
     * @param data 用户信息
     * @return 结果
     */
    public int insertData(DmData data);

    /**
     * 保存资料信息
     *
     * @param dmData 用户信息
     * @return 结果
     */
    public int updateData(DmData dmData);
}
