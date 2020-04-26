package com.szps.web.mapper.drainage;

import java.util.List;

import com.szps.web.domain.drainage.Household;

/**
 * Household对象 持久层
 * @author zxc
 *
 */
public interface HouseholdMapper {
	/**
	 * 查询全部的排水户信息
	 * @param household
	 * @return
	 */
	public List<Household> selectAllHousehold(Household household);
	
	/**
	 * 新增排水户
	 * @param household
	 */
	public void insertHousehold(Household household);
	
	/**
     * 校验排水户编号是否唯一
     */
	public Household checkHouseholdIdUnique(int household_id);
	
	/**
	 * 通过排水户编号查询排水户
	 * @param household_id
	 * @return
	 */
	public Household selectHouseholdById(int household_id);
	
	/**
	 * 修改保存排水户信息
	 * @param household
	 */
	public void updateHousehold(Household household);
	
	/**
	 * 删除排水户以及排水户下排水口
	 * @param []ids
	 * @return
	 */
	public int deleteHouseholdById(Integer[] ids);
	public int deleteDrainById(Integer[] ids);
	
	/**
	 * 查询全市摸查排水户总数
	 * @return
	 */
	public int selectHouseholdCount();
	
	/**
	 * 查询全市已提交排水户总数
	 * @return
	 */
	public int selectHouseholdRecordStateCount();
	
	/**
	 * 查询全市排污许可证到期总数
	 * @return
	 */
	public int pwzdqCount();
	
	/**
	 * 查询全市排水许可证到期总数
	 * @return
	 */
	public int pszdqCount();
	
	/**
	 * 查询全部排水户所在行政区（用于柱形图）
	 */
	public List<String> selectAllHouseholdAdministrative();
	
	/**
	 *  查询排水户污水类别（用于饼图）
	 * @return
	 */
	public List<String> selectAllSewageCategory();
	
	/**
	 * 查询各区排水证已到期数量
	 * @return
	 */
	public List<String> selectDrainageLicenseExpire();
	
	/**
	 * 查询各行政区污水类别(用于堆叠柱状图)
	 */
	public List<Household> selectAllAdminiSewage();
	
	/**
	 * 查询各行政区排水户记录状态（用于堆叠柱状图）
	 */
	public List<Household> selectAllAdminiRecord();
}
