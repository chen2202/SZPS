package com.szps.web.service.dm;

import com.szps.web.domain.dm.DmAudit;
import com.szps.web.domain.dm.DmData;

public interface IDmAuditService {

    /**
     * 保存审批信息
     *
     * @param audit 审批信息
     * @return 结果
     */
    public int insertAudit(DmAudit audit);

    /**
     * 审批状态修改
     *
     * @param dmAudit 角色信息
     * @return 结果
     */
    public int changeStatus(DmAudit dmAudit);

    /**
     * 审批资料删除
     *
     * @param ids id集合
     * @return 结果
     */
    public int deleteAuditByDataIds(String ids);

}
