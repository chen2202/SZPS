package com.szps.web.service.supervise.Impl;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.mapper.supervise.TbRuleMapper;
import com.szps.web.mapper.supervise.TbStaffMapper;
import com.szps.web.service.supervise.RuleService;
import com.szps.web.service.supervise.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private TbRuleMapper tbRuleMapper;

    @Override

    public List<TbRule> selectRuleList(TbRule rule) {
        return tbRuleMapper.selectRuleList(rule);
    }

    @Override
    public List<TbRule> selectRuleAll() {
        return tbRuleMapper.selectAll();
    }

    @Override
    public TbRule selectRuleById(String ruleNumber) {
        return tbRuleMapper.selectByPrimaryKey(ruleNumber);
    }

    @Override
    public int deleteRuleById(String ruleNumber) {
        return tbRuleMapper.deleteByPrimaryKey(ruleNumber);
    }

    @Override
    public int deleteRuleByIds(String ids) throws Exception {
        Long[] Ids = Convert.toLongArray(ids);
        return tbRuleMapper.deleteRuleByIds(Ids);

    }

    @Override
    public int insertRule(TbRule rule) {
        return tbRuleMapper.insert(rule);
    }

    @Override
    public int updateRule(TbRule rule) {
        return tbRuleMapper.updateByPrimaryKey(rule);
    }
}
