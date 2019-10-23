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
}
