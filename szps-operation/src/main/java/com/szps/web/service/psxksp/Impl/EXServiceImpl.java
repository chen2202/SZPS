package com.szps.web.service.psxksp.Impl;

import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.mapper.psxksp.EXMapper;
import com.szps.web.service.psxksp.EXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EXServiceImpl implements EXService{

    @Autowired
    private EXMapper exMapper;


    @Override
    public List<EX_GDBS_SB> selectTaskAll() {
        return exMapper.selectAll();
    }

    @Override
    public List<EX_GDBS_SB> selectTaskBytime(String BYZD4) {
        return exMapper.selectTaskBytime(BYZD4);
    }

    @Override
    public EX_GDBS_SB selectById(String sblsh) {
        return exMapper.selectById(sblsh);
    }

    @Override
    public List<EX_GDBS_SB> selectTaskWaiting(EX_GDBS_SB exGdbsSb) {
        return exMapper.selectTaskWaiting( exGdbsSb);
    }

    @Override
    public List<EX_GDBS_SB> selectTaskDone(EX_GDBS_SB exGdbsSb) {
        return exMapper.selectTaskDone(exGdbsSb);
    }

    @Override
    public int updateEx(EX_GDBS_SB ex) {
        return exMapper.updateEx(ex);
    }

}
