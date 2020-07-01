package com.szps.web.service.drainage.impl;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
import com.szps.web.domain.drainage.Drain;
import com.szps.web.mapper.drainage.DrainMapper;
import com.szps.web.service.drainage.DrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrainServiceImpl implements DrainService{
	@Autowired
	private DrainMapper drainMapper;
	
	/**
	 * 通过排水户编号查询该排水户下所有排水口
	 */
	//@DataScope
	public List<Drain> selectDrainByHouseholdId(Drain drain){
		return drainMapper.selectDrainByHouseholdId(drain);
	}
	
	/**
	 * 新增排水口
	 * @param drain
	 */
	public void insertDrain(Drain drain) {
		drainMapper.insertDrain(drain);
	}
	
	/**
	 * 校验排水口编号唯一性
	 * @param drain
	 * @return
	 */
	public String checkDrainUnique(Drain drain) {
		Drain d = null;
		d = drainMapper.checkDrainUnique(drain.getDrain_id());
		if(d != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**
	 * 通过排水口编号查询排水口
	 * @param drain_id
	 * @return
	 */
	public Drain selectDrainById(String drain_id) {
		return drainMapper.selectDrainById(drain_id);
	}
	
	/**
	 * 修改排水口信息
	 * @param drain
	 */
	public void updateDrain(Drain drain) {
		drainMapper.updateDrain(drain);
	}
	
	/**
	 * 通过排水口编号删除排水口
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	public int deleteDrainById(String ids) throws BusinessException{
		String[] drain_ids = Convert.toStrArray(ids);
		return drainMapper.deleteDrainById(drain_ids);
	}
}
