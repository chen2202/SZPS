package com.szps.web.domain.supervise;

public class TbRule {
    private String ruleNumber;

    private String ruleContent;

    private String ruleType;
    private String ruleName;
    private String ruleBasis;
    private String ruleScale;
    private String ruleMain;

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

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleBasis() {
        return ruleBasis;
    }

    public void setRuleBasis(String ruleBasis) {
        this.ruleBasis = ruleBasis;
    }

    public String getRuleScale() {
        return ruleScale;
    }

    public void setRuleScale(String ruleScale) {
        this.ruleScale = ruleScale;
    }

    public String getRuleMain() {
        return ruleMain;
    }

    public void setRuleMain(String ruleMain) {
        this.ruleMain = ruleMain;
    }
}