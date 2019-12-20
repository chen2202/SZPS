package com.szps.web.service.dm;


import com.szps.web.domain.dm.DmData;
import com.szps.web.domain.dm.DmPermission;
import com.szps.web.domain.dm.DmUDP;

import java.util.List;

public interface IDmPerService {

    /**
     * 保存资料权限申请信息
     *
     * @param per 用户信息
     * @return 结果
     */
    public int insertPer(DmPermission per);


    /**
     * 根据条件分页查询资料权限申请列表
     *
     * @param udp
     * @return 资料信息集合信息
     */
    public List<DmUDP> selectApprovalPerList(DmUDP udp);

    /**
     * 根据条件分页查询审批通过的资料权限申请列表
     *
     * @param udp
     * @return 资料信息集合信息
     */
    public List<DmUDP> selectPassPerList(DmUDP udp);


    /**
     * 资料权限状态修改
     *
     * @param perId     权限编号
     * @param perStatus 权限状态
     * @return 结果
     */
    public int changeStatus(Long perId,String perStatus);


    /**
     * 资料权限状态修改(多选)
     *
     * @param ids 需要修改的数据ID
     * @return 结果
     */
    public void changeStatusByIds(String ids,String status);

    /**
     * 批量删除资料
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deletePerByIds(String ids) throws Exception;

    /**
     * 批量删除资料
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deletePerByDataIds(String ids) throws Exception;

    /**
     * 通过用户id查询用户有权访问的资料
     *
     */
    public List<DmPermission> selectDataListByUserId(DmData dmData,Long userId);

    /**
     * 检查该用户是否已经具有该资料访问权限
     */
    public int checkPerExist(Long dataId,Long userId);

}
