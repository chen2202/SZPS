package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Check extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6727782972246750805L;
	private Long id;
	private Long deptId;
	private String checkDate;// 验收日期
	private String chineseName;// 中文名称
	private String englishName;// 英文名称
	private String nameplate;// 铭牌
	private String supplier;// 供应商
	private String devModel;// 型号
	private String devNumber;// 机器编号
	private String arrivalDate;// 到货日期
	private String devSize;// 外形尺寸
	private String devPower;// 功率/电压
	private String quantity;// 数量
	private String warrantyPeriod;// 保修
	private String auxiliary;// 辅机
	private String part;// 配件
	private String devType;// 设备类型
	private String unitPrice;// 单价
	private String trafficCost;// 运输费
	private String installCost;// 安装费
	private String taxes;// 税金
	private String sumCost;// 总额
	private String accessory;// 附件
	private String keeper;// 保管人
	private String appearanceC;// 外观-国标
	private String securityC;// 安全性-国标
	private String propertyC;// 性能指标-国标
	private String materialsC;// 材料-国标
	private String qualityC;// 生产产品质量-国标
	private String needFuncC;// 应具功能-国标
	private String readFuncC;// 实际使用功能-国标
	private String appearanceB;// 外观-立标
	private String securityB;// 安全性-立标
	private String propertyB;// 性能指标-立标
	private String materialsB;// 材料-立标
	private String qualityB;// 生产产品质量-立标
	private String needFuncB;// 应具功能-立标
	private String readFuncB;// 实际使用功能-立标
	private String appearanceA;// 外观-合标
	private String securityA;// 安全性-合标
	private String propertyA;// 性能指标-合标
	private String materialsA;// 材料-合标
	private String qualityA;// 生产产品质量-合标
	private String needFuncA;// 应具功能-合标
	private String readFuncA;// 实际使用功能-合标
	private String devSpec;// 说明
	private String purcDeptSign;// 采购部门签字人
	private String useDeptSign;// 使用部门签字人
	private String facDeptSign;// 设备设施部签字人
	private String leaderSign;// 分管领导

	private String delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getNameplate() {
		return nameplate;
	}

	public void setNameplate(String nameplate) {
		this.nameplate = nameplate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	public String getDevNumber() {
		return devNumber;
	}

	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDevSize() {
		return devSize;
	}

	public void setDevSize(String devSize) {
		this.devSize = devSize;
	}

	public String getDevPower() {
		return devPower;
	}

	public void setDevPower(String devPower) {
		this.devPower = devPower;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getAuxiliary() {
		return auxiliary;
	}

	public void setAuxiliary(String auxiliary) {
		this.auxiliary = auxiliary;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDevType() {
		return devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTrafficCost() {
		return trafficCost;
	}

	public void setTrafficCost(String trafficCost) {
		this.trafficCost = trafficCost;
	}

	public String getInstallCost() {
		return installCost;
	}

	public void setInstallCost(String installCost) {
		this.installCost = installCost;
	}

	public String getTaxes() {
		return taxes;
	}

	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}

	public String getSumCost() {
		return sumCost;
	}

	public void setSumCost(String sumCost) {
		this.sumCost = sumCost;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getKeeper() {
		return keeper;
	}

	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}

	public String getAppearanceC() {
		return appearanceC;
	}

	public void setAppearanceC(String appearanceC) {
		this.appearanceC = appearanceC;
	}

	public String getSecurityC() {
		return securityC;
	}

	public void setSecurityC(String securityC) {
		this.securityC = securityC;
	}

	public String getPropertyC() {
		return propertyC;
	}

	public void setPropertyC(String propertyC) {
		this.propertyC = propertyC;
	}

	public String getMaterialsC() {
		return materialsC;
	}

	public void setMaterialsC(String materialsC) {
		this.materialsC = materialsC;
	}

	public String getQualityC() {
		return qualityC;
	}

	public void setQualityC(String qualityC) {
		this.qualityC = qualityC;
	}

	public String getNeedFuncC() {
		return needFuncC;
	}

	public void setNeedFuncC(String needFuncC) {
		this.needFuncC = needFuncC;
	}

	public String getReadFuncC() {
		return readFuncC;
	}

	public void setReadFuncC(String readFuncC) {
		this.readFuncC = readFuncC;
	}

	public String getAppearanceB() {
		return appearanceB;
	}

	public void setAppearanceB(String appearanceB) {
		this.appearanceB = appearanceB;
	}

	public String getSecurityB() {
		return securityB;
	}

	public void setSecurityB(String securityB) {
		this.securityB = securityB;
	}

	public String getPropertyB() {
		return propertyB;
	}

	public void setPropertyB(String propertyB) {
		this.propertyB = propertyB;
	}

	public String getMaterialsB() {
		return materialsB;
	}

	public void setMaterialsB(String materialsB) {
		this.materialsB = materialsB;
	}

	public String getQualityB() {
		return qualityB;
	}

	public void setQualityB(String qualityB) {
		this.qualityB = qualityB;
	}

	public String getNeedFuncB() {
		return needFuncB;
	}

	public void setNeedFuncB(String needFuncB) {
		this.needFuncB = needFuncB;
	}

	public String getReadFuncB() {
		return readFuncB;
	}

	public void setReadFuncB(String readFuncB) {
		this.readFuncB = readFuncB;
	}

	public String getAppearanceA() {
		return appearanceA;
	}

	public void setAppearanceA(String appearanceA) {
		this.appearanceA = appearanceA;
	}

	public String getSecurityA() {
		return securityA;
	}

	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}

	public String getPropertyA() {
		return propertyA;
	}

	public void setPropertyA(String propertyA) {
		this.propertyA = propertyA;
	}

	public String getMaterialsA() {
		return materialsA;
	}

	public void setMaterialsA(String materialsA) {
		this.materialsA = materialsA;
	}

	public String getQualityA() {
		return qualityA;
	}

	public void setQualityA(String qualityA) {
		this.qualityA = qualityA;
	}

	public String getNeedFuncA() {
		return needFuncA;
	}

	public void setNeedFuncA(String needFuncA) {
		this.needFuncA = needFuncA;
	}

	public String getReadFuncA() {
		return readFuncA;
	}

	public void setReadFuncA(String readFuncA) {
		this.readFuncA = readFuncA;
	}

	public String getDevSpec() {
		return devSpec;
	}

	public void setDevSpec(String devSpec) {
		this.devSpec = devSpec;
	}

	public String getPurcDeptSign() {
		return purcDeptSign;
	}

	public void setPurcDeptSign(String purcDeptSign) {
		this.purcDeptSign = purcDeptSign;
	}

	public String getUseDeptSign() {
		return useDeptSign;
	}

	public void setUseDeptSign(String useDeptSign) {
		this.useDeptSign = useDeptSign;
	}

	public String getFacDeptSign() {
		return facDeptSign;
	}

	public void setFacDeptSign(String facDeptSign) {
		this.facDeptSign = facDeptSign;
	}

	public String getLeaderSign() {
		return leaderSign;
	}

	public void setLeaderSign(String leaderSign) {
		this.leaderSign = leaderSign;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	

}
