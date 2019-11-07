package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.MaintainPlan;
import com.szps.web.mapper.dev.MaintainPlanMapper;
import com.szps.web.service.dev.IMaintainPlanService;
@Service
public class MaintainPlanServiceImpl implements IMaintainPlanService {

	@Autowired
	private MaintainPlanMapper mapper;
	@Override
	public List<MaintainPlan> selectList(MaintainPlan obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public MaintainPlan selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(MaintainPlan obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		Long[] idsL = Convert.toLongArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(MaintainPlan obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}
