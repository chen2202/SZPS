package com.szps.web.service.dm.impl;

import com.szps.web.domain.dm.DmLog;
import com.szps.web.mapper.dm.DmLogMapper;
import com.szps.web.service.dm.IDmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmLogServiceImpl implements IDmLogService {

    @Autowired
    private DmLogMapper dmLogMapper;

    @Override
    public List<DmLog> selectLogList(DmLog dmLog) {
        return dmLogMapper.selectLogList(dmLog);
    }

}
