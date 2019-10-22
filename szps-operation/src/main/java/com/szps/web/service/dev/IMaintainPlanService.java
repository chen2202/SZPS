package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.MaintainPlan;

public interface IMaintainPlanService {

	public List<MaintainPlan> selectList(MaintainPlan obj);

	public MaintainPlan selectById(Long id);

	public int insert(MaintainPlan obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(MaintainPlan obj);
}