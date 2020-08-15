package com.szps.web.domain.supervise;
import com.szps.common.annotation.Excel;

public class TbRule {

    @Excel(name = "事项编号", prompt = "事项编号")
    private String ruleNumber;

    @Excel(name = "事项名称", prompt = "事项名称")
    private String ruleName;

    @Excel(name = "事项内容", prompt = "事项内容")
    private String ruleContent;

    @Excel(name = "事项类型", prompt = "事项类型")
    private String ruleType;

    @Excel(name = "事项依据", prompt = "事项依据")
    private String ruleBasis;

    @Excel(name = "事项比例", prompt = "事项比例")
    private String ruleScale;

    @Excel(name = "责任单位", prompt = "责任单位")
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