package com.szps.web.domain.dm;

import com.szps.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 污水处理费表
 *
 * @author vic
 *
 */
public class DmCost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long costId;

    /** 水质净化厂 */
    private String costFactory;

    /** 运营单位 */
    private String costCompany;

    /** 申请支付时间 */
    private Date costApplyTime;

    /** 实际支付月份 */
    private String costPayTime;

    /** 实际处理水量 */
    private double costWaterVolume;

    /** 实付处理费 */
    private double costPayMoney;

    /** 处罚金额 */
    private double costPunishMoney;

    /** 处罚原因 */
    private String costPunishReason;

    /** 备注 */
    private String costRemark;

    /** 文件名 */
    private String costFileName;

    /** 文件相对路径 */
    private String costFilePath;

//    其他属性
    private String type;

    private String time;

    public Long getCostId() {
        return costId;
    }

    public void setCostId(Long costId) {
        this.costId = costId;
    }

    public String getCostFactory() {
        return costFactory;
    }

    public void setCostFactory(String costFactory) {
        this.costFactory = costFactory;
    }

    public String getCostCompany() {
        return costCompany;
    }

    public void setCostCompany(String costCompany) {
        this.costCompany = costCompany;
    }

    public Date getCostApplyTime() {
        return costApplyTime;
    }

    public void setCostApplyTime(Date costApplyTime) {
        this.costApplyTime = costApplyTime;
    }

    public String getCostPayTime() {
        return costPayTime;
    }

    public void setCostPayTime(String costPayTime) {
        this.costPayTime = costPayTime;
    }

    public double getCostWaterVolume() {
        return costWaterVolume;
    }

    public void setCostWaterVolume(double costWaterVolume) {
        this.costWaterVolume = costWaterVolume;
    }

    public double getCostPayMoney() {
        return costPayMoney;
    }

    public void setCostPayMoney(double costPayMoney) {
        this.costPayMoney = costPayMoney;
    }

    public double getCostPunishMoney() {
        return costPunishMoney;
    }

    public void setCostPunishMoney(double costPunishMoney) {
        this.costPunishMoney = costPunishMoney;
    }

    public String getCostPunishReason() {
        return costPunishReason;
    }

    public void setCostPunishReason(String costPunishReason) {
        this.costPunishReason = costPunishReason;
    }

    public String getCostRemark() {
        return costRemark;
    }

    public void setCostRemark(String costRemark) {
        this.costRemark = costRemark;
    }

    public String getCostFileName() {
        return costFileName;
    }

    public void setCostFileName(String costFileName) {
        this.costFileName = costFileName;
    }

    public String getCostFilePath() {
        return costFilePath;
    }

    public void setCostFilePath(String costFilePath) {
        this.costFilePath = costFilePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
