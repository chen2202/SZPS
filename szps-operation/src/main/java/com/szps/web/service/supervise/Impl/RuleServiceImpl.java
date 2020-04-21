package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.mapper.supervise.TbRuleMapper;
import com.szps.web.service.supervise.RuleService;
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
    public String selectRuleByRuleName(String ruleName) {
        return tbRuleMapper.selectByName(ruleName);
    }

    @Override
    public String selectRuleByRuleNameScale(String ruleName) {
        return tbRuleMapper.selectByNameScale(ruleName);
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
