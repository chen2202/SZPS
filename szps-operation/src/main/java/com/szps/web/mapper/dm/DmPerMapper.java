package com.szps.web.mapper.dm;

import com.szps.web.domain.dm.DmData;
import com.szps.web.domain.dm.DmPermission;
import com.szps.web.domain.dm.DmUDP;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmPerMapper {

    /**
     * 保存资料权限申请信息
     *
     * @param per 用户信息
     * @return 结果
     */
    public int insertPer(DmPermission per);

    /**
     * 根据条件分页查询未审批的资料权限申请列表
     *
     * @param udp
     * @return 资料信息集合信息
     */
    public List<DmUDP> selectNotApprovalPerList(DmUDP udp);

    /**
     * 根据条件分页查询审批通过的资料权限申请列表
     *
     * @param udp
     * @return 资料信息集合信息
     */
    public List<DmUDP> selectPassPerList(DmUDP udp);

    /**
     * 根据条件分页查询审批驳回的资料权限申请列表
     *
     * @param udp
     * @return 资料信息集合信息
     */
    public List<DmUDP> selectRejectPerList(DmUDP udp);


    /**
     * 资料权限状态修改
     *
     * @param perId     权限编号
     * @param perStatus 权限状态
     * @return 结果
     */
    public int changeStatus(@Param("perId") Long perId, @Param("perStatus") String perStatus);


    /**
     * 资料权限状态修改(多选)
     *
     * @param ids 需要修改的数据ID
     * @return 结果
     */
    public void changeStatusByIds(Long[] ids,String status);

    /**
     * 批量删除资料信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerByIds(Long[] ids);

    /**
     * 批量删除资料信息
     *
     * @param ids 需要删除的数据dataId
     * @return 结果
     */
    public int deletePerByDataIds(Long[] ids);

    /**
     * 通过用户id查询用户有权访问的资料
     *
     */
    public List<DmPermission> selectDataListByUserId(@Param("dmData")DmData dmData,@Param("per_userId") Long per_userId);


    /**
     * 检查该用户是否已经具有该资料访问权限
     */
    public int checkPerExist(@Param("dataId")Long dataId,@Param("userId") Long userId);

}
