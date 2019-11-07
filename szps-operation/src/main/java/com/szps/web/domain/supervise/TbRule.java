package com.szps.web.domain.supervise;

public class TbRule {
    private String ruleNumber;

    private String ruleContent;

    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber == null ? null : ruleNumber.trim();
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent == null ? null : ruleContent.trim();
    }
}