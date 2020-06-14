package com.szps.web.mapper.dm;

import com.szps.web.domain.dm.DmAudit;
import com.szps.web.domain.dm.DmData;
import org.springframework.stereotype.Repository;

/**
 * 审批表 数据层
 *
 * @author vic
 */
@Repository
public interface DmAuditMapper {

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
    public int deleteAuditByDataIds(Long[] ids);

}
