package com.szps.web.service.supervise;

import com.szps.web.domain.supervise.TbRule;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface RuleService
{

    public List<TbRule> selectRuleList(TbRule rule);


    public List<TbRule> selectRuleAll();


    public TbRule selectRuleById(String ruleNumber);

    public String selectRuleByRuleName(String ruleName);
    public String selectRuleByRuleNameScale(String ruleName);

    public int deleteRuleById(String ruleNumber);

    /**
     * 批量删除角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteRuleByIds(String ids) throws Exception;


    public int insertRule(TbRule rule);

    public int updateRule(TbRule rule);
     public String[] selectRuleName();

}
