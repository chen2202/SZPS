package com.szps.web.service.drainage;

import java.util.List;

import com.szps.web.domain.drainage.Household;

public interface HouseholdService {
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
	public String checkHouseholdIdUnique(Household household);
	
	/**
	 * 通过排水户编号查询排水户
	 * @param household_id
	 * @return
	 */
	public Household selectHouseholdById(String household_id);
	
	/**
	 * 修改保存排水户信息
	 * @param household
	 */
	public void updateHousehold(Household household);
	
	/**
	 * 删除排水户以及排水户下排水口
	 * @param ids
	 * @return
	 */
	public int deleteHouseholdById(String ids) throws Exception;
	public int deleteDrainById(String ids) throws Exception;
}
