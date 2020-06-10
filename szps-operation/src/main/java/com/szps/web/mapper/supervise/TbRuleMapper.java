package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbRule;

import java.util.List;

public interface TbRuleMapper {
    int deleteByPrimaryKey(String ruleNumber);

    int insert(TbRule record);

    TbRule selectByPrimaryKey(String ruleNumber);

    List<TbRule> selectAll();

    int updateByPrimaryKey(TbRule record);

    List<TbRule> selectRuleList(TbRule rule);

    int deleteRuleByIds(Long[] ids);
    String selectByName(String ruleName);
    String selectByNameScale(String ruleName);
    String []selectRuleName();
}