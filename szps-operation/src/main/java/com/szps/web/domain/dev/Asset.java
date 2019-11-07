package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Asset extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4950361515466555743L;
	private Long deptId;
	private String name;// 设备名称
	private String number;// 设备编号
	private String model;// 设备型号
	private String specs;// 设备规格
	private String abcCategory;// ＡＢＣ分类
	private String devType;// 设备类型
	private String status;// 设备状态
	private String purpost;// 生产用途
	private String useDep;// 使用部门
	private String installPlace;// 安装地点
	private String code;// 资产代码
	private String manufacturer;// 制造厂商
	private String makeCountry;// 制造国别
//	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private String proDate;// 出厂日期
	private String proCode;// 出厂编号
//	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private String useDate;// 启用日期
	private String assetName;// 资产名称
	private String supplier;// 供应商
	private String supplierPhone;// 供应商电话
	private String gPeriod;// 保修期
	private String mCycle;// 保养周期
	private String oValue;// 设备原值
	private String assetType;// 资产类别
	private String devVoltage;// 电压
	private String lift;// 扬程
	private String packWeight;// 装重量
	private String remark1;// 备注
	private String DPower;// 功率
	private String flow;// 流量
	private String pipeCaliber;// 管道口径
	private String remark2;// 备注
	private String Dcurrent;// 电流
	private String wight;// 机体重量
	private String material;// 材质
	private String remark3;// 备注
	private String volume;// 容积
	private String pressure;// 设计压力
	private String revolution;// 电机转数
	private String remark4;// 备注
	private String auNameFirst;// 设备名称
	private String auNameSec;// 设备名称
	private String auPower;// 功率
	private String auModelFirst;// 型号
	private String auModelSec;// 型号
	private String auCurrent;// 电流
	private String remark5;// 备注
	private String auNumber;// 设备编号
	private String auVoltage;// 电压
	private String remark6;// 备注
	private String auManufacturer;// 制造厂商
	private String auMPhone;// 电话
	private String auSupplier;// 供应商
	private String auSPhone;// 电话
	private String remark7;// 备注
	private String delFlag;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	public String getAbcCategory() {
		return abcCategory;
	}
	public void setAbcCategory(String abcCategory) {
		this.abcCategory = abcCategory;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPurpost() {
		return purpost;
	}
	public void setPurpost(String purpost) {
		this.purpost = purpost;
	}
	public String getUseDep() {
		return useDep;
	}
	public void setUseDep(String useDep) {
		this.useDep = useDep;
	}
	public String getInstallPlace() {
		return installPlace;
	}
	public void setInstallPlace(String installPlace) {
		this.installPlace = installPlace;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMakeCountry() {
		return makeCountry;
	}
	public void setMakeCountry(String makeCountry) {
		this.makeCountry = makeCountry;
	}
	public String getProDate() {
		return proDate;
	}
	public void setProDate(String proDate) {
		this.proDate = proDate;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplierPhone() {
		return supplierPhone;
	}
	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	public String getgPeriod() {
		return gPeriod;
	}
	public void setgPeriod(String gPeriod) {
		this.gPeriod = gPeriod;
	}
	public String getDevVoltage() {
		return devVoltage;
	}
	public void setDevVoltage(String devVoltage) {
		this.devVoltage = devVoltage;
	}
	public String getLift() {
		return lift;
	}
	public void setLift(String lift) {
		this.lift = lift;
	}
	public String getPackWeight() {
		return packWeight;
	}
	public void setPackWeight(String packWeight) {
		this.packWeight = packWeight;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getDPower() {
		return DPower;
	}
	public void setDPower(String dPower) {
		DPower = dPower;
	}
	public String getFlow() {
		return flow;
	}
	public void setFlow(String flow) {
		this.flow = flow;
	}
	public String getPipeCaliber() {
		return pipeCaliber;
	}
	public void setPipeCaliber(String pipeCaliber) {
		this.pipeCaliber = pipeCaliber;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getDcurrent() {
		return Dcurrent;
	}
	public void setDcurrent(String dcurrent) {
		Dcurrent = dcurrent;
	}
	public String getWight() {
		return wight;
	}
	public void setWight(String wight) {
		this.wight = wight;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getRevolution() {
		return revolution;
	}
	public void setRevolution(String revolution) {
		this.revolution = revolution;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public String getAuNameFirst() {
		return auNameFirst;
	}
	public void setAuNameFirst(String auNameFirst) {
		this.auNameFirst = auNameFirst;
	}
	public String getAuNameSec() {
		return auNameSec;
	}
	public void setAuNameSec(String auNameSec) {
		this.auNameSec = auNameSec;
	}
	public String getAuPower() {
		return auPower;
	}
	public void setAuPower(String auPower) {
		this.auPower = auPower;
	}
	public String getAuModelFirst() {
		return auModelFirst;
	}
	public void setAuModelFirst(String auModelFirst) {
		this.auModelFirst = auModelFirst;
	}
	public String getAuModelSec() {
		return auModelSec;
	}
	public void setAuModelSec(String auModelSec) {
		this.auModelSec = auModelSec;
	}
	public String getAuCurrent() {
		return auCurrent;
	}
	public void setAuCurrent(String auCurrent) {
		this.auCurrent = auCurrent;
	}
	public String getRemark5() {
		return remark5;
	}
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	public String getAuNumber() {
		return auNumber;
	}
	public void setAuNumber(String auNumber) {
		this.auNumber = auNumber;
	}
	public String getAuVoltage() {
		return auVoltage;
	}
	public void setAuVoltage(String auVoltage) {
		this.auVoltage = auVoltage;
	}
	public String getRemark6() {
		return remark6;
	}
	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}
	public String getAuManufacturer() {
		return auManufacturer;
	}
	public void setAuManufacturer(String auManufacturer) {
		this.auManufacturer = auManufacturer;
	}
	public String getAuMPhone() {
		return auMPhone;
	}
	public void setAuMPhone(String auMPhone) {
		this.auMPhone = auMPhone;
	}
	public String getAuSupplier() {
		return auSupplier;
	}
	public void setAuSupplier(String auSupplier) {
		this.auSupplier = auSupplier;
	}
	public String getAuSPhone() {
		return auSPhone;
	}
	public void setAuSPhone(String auSPhone) {
		this.auSPhone = auSPhone;
	}
	public String getRemark7() {
		return remark7;
	}
	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}
	public String getmCycle() {
		return mCycle;
	}
	public void setmCycle(String mCycle) {
		this.mCycle = mCycle;
	}
	public String getoValue() {
		return oValue;
	}
	public void setoValue(String oValue) {
		this.oValue = oValue;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	/**
	 * @return the deptId
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
