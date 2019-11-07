package com.szps.web.service.dm.impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dm.DmAudit;
import com.szps.web.mapper.dm.DmAuditMapper;
import com.szps.web.service.dm.IDmAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmAuditServiceImpl implements IDmAuditService {


    @Autowired
    private DmAuditMapper dmAuditMapper;

    @Override
    public int insertAudit(DmAudit audit) {
        return dmAuditMapper.insertAudit(audit);
    }

    @Override
    public int changeStatus(DmAudit dmAudit) {
        return dmAuditMapper.changeStatus(dmAudit);
    }

    @Override
    public int deleteAuditByDataIds(String ids) {
        Long[] dataIds = Convert.toLongArray(ids);
        return dmAuditMapper.deleteAuditByDataIds(dataIds);
    }

}
