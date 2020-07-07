package com.szps.web.service.drainage.impl;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
import com.szps.web.domain.drainage.Household;
import com.szps.web.mapper.drainage.HouseholdMapper;
import com.szps.web.service.drainage.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService{
	@Autowired
	private HouseholdMapper householdMapper;
	
	/**
	 * 查询全部的排水户信息
	 * @param household
	 * @return
	 */
	public List<Household> selectAllHousehold(Household household){
		return householdMapper.selectAllHousehold(household);
	}
	
	/**
	 * 新增排水户
	 * @param household
	 */
	public void insertHousehold(Household household) {
		householdMapper.insertHousehold(household);
	}
	
	/**
     * 校验排水户编号是否唯一
     * @return 如果排水户编号唯一，返回"0"，不唯一返回"1"
     */
	public String checkHouseholdIdUnique(Household household) {
		Household h = null;
		h = householdMapper.checkHouseholdIdUnique(household.getHousehold_id());
		if(h != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**
	 * 通过排水户编号查询排水户
	 * @param household_id
	 * @return
	 */
	public Household selectHouseholdById(int household_id) {
		return householdMapper.selectHouseholdById(household_id);
	}
	
	/**
	 * 修改保存排水户信息
	 * @param household
	 */
	public void updateHousehold(Household household) {
		householdMapper.updateHousehold(household);
	}
	
	/**
	 * 删除排水户以及排水户下排水口
	 * @param ids
	 * @return
	 */
	public int deleteHouseholdById(String ids) throws BusinessException{
		Integer[] household_ids = Convert.toIntArray(ids);
		return householdMapper.deleteHouseholdById(household_ids);
	}
	public int deleteDrainById(String ids) throws BusinessException{
		Integer[] household_ids = Convert.toIntArray(ids);
		return householdMapper.deleteDrainById(household_ids);
	}
	
	/**
	 * 查询全市摸查的排水户总数
	 */
	public int selectHouseholdCount() {
		return householdMapper.selectHouseholdCount();
	}
	
	/**
	 * 查询全市已提交的排水户总数
	 */
	public int selectHouseholdRecordStateCount() {
		return householdMapper.selectHouseholdRecordStateCount();
	}
	
	/**
	 * 查询全市排污许可证到期
	 * @return
	 */
	public int pwzdqCount() {
		return householdMapper.pwzdqCount();
	}
	
	/**
	 * 查询全市排水许可证到期
	 * @return
	 */
	public int pszdqCount() {
		return householdMapper.pszdqCount();
	}
	
	/**
	 * 查询全部排水户所在行政区（用于柱形图）
	 */
	public List<String> selectAllHouseholdAdministrative(){
		return householdMapper.selectAllHouseholdAdministrative();
	}
	
	/**
	 *  查询排水户污水类别（用于饼图）
	 * @return
	 */
	public List<String> selectAllSewageCategory(){
		return householdMapper.selectAllSewageCategory();
	}
	
	/**
	 * 查询各区排水证已到期数量
	 * @return
	 */
	public List<String> selectDrainageLicenseExpire(){
		return householdMapper.selectDrainageLicenseExpire();
	}
	
	/**
	 * 查询各行政区污水类别(用于堆叠柱状图)
	 */
	public List<Household> selectAllAdminiSewage(){
		return householdMapper.selectAllAdminiSewage();
	}
	
	/**
	 * 查询各行政区排水户记录状态（用于堆叠柱状图）
	 */
	public List<Household> selectAllAdminiRecord(){
		return householdMapper.selectAllAdminiRecord();
	}
}
