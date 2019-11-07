package com.szps.web.service.dm.impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dm.DmData;
import com.szps.web.domain.dm.DmPermission;
import com.szps.web.domain.dm.DmUDP;
import com.szps.web.mapper.dm.DmPerMapper;
import com.szps.web.service.dm.IDmPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmPerServiceImpl implements IDmPerService {


    @Autowired
    private DmPerMapper dmPerMapper;

    @Override
    public int insertPer(DmPermission per) {
        return dmPerMapper.insertPer(per);
    }

    @Override
    public List<DmUDP> selectNotApprovalPerList(DmUDP udp) {
        return dmPerMapper.selectNotApprovalPerList(udp);
    }

    @Override
    public List<DmUDP> selectPassPerList(DmUDP udp) {
        return dmPerMapper.selectPassPerList(udp);
    }

    @Override
    public List<DmUDP> selectRejectPerList(DmUDP udp) {
        return dmPerMapper.selectRejectPerList(udp);
    }

    @Override
    public int changeStatus(Long perId,String perStatus) {
        return dmPerMapper.changeStatus(perId,perStatus);
    }

    @Override
    public void changeStatusByIds(String ids, String status) {
        Long[] perIds = Convert.toLongArray(ids);
        for (Long id:perIds) {
            changeStatus(id,status);
        }
    }

    @Override
    public int deletePerByIds(String ids) throws Exception {
        Long[] perIds = Convert.toLongArray(ids);
        return dmPerMapper.deletePerByIds(perIds);
    }

    @Override
    public int deletePerByDataIds(String ids) throws Exception {
        Long[] dataIds = Convert.toLongArray(ids);
        return dmPerMapper.deletePerByDataIds(dataIds);
    }

    @Override
    public List<DmPermission> selectDataListByUserId(DmData dmData,Long per_userId) {
        return dmPerMapper.selectDataListByUserId(dmData,per_userId);
    }

    @Override
    public int checkPerExist(Long dataId,Long userId) {
        return dmPerMapper.checkPerExist(dataId,userId);
    }


}
