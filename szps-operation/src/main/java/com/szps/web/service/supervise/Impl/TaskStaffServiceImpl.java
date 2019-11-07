package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.domain.supervise.TbTaskStaff;
import com.szps.web.mapper.supervise.TbRuleMapper;
import com.szps.web.mapper.supervise.TbTaskStaffMapper;
import com.szps.web.service.supervise.RuleService;
import com.szps.web.service.supervise.TaskStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStaffServiceImpl implements TaskStaffService {


    @Autowired
    private TbTaskStaffMapper mapper;

    @Override
    public List<TbTaskStaff> selectTbTaskStaffAll() {
        return null;
    }

    @Override
    public List<TbTaskStaff> selectTbTaskStaffById(String taskNumber) {
        return mapper.selectByPrimaryKey(taskNumber);
    }

    @Override
    public int deleteTbTaskStaffById(String taskNumber) {
        return mapper.deleteByPrimaryKey(taskNumber);
    }

    @Override
    public int insertTbTaskStaff(TbTaskStaff tbTaskStaff) {
        return mapper.insert(tbTaskStaff);
    }

    @Override
    public int updateTbTaskStaff(String tbTaskStaff) {
        return mapper.updateByPrimaryKey(tbTaskStaff);
    }
}
