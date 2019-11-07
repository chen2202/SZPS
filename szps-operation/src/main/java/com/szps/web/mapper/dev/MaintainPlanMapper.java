package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.MaintainPlan;

public interface MaintainPlanMapper {

	public List<MaintainPlan> selectList(MaintainPlan obj);

	public MaintainPlan selectById(Long id);

	public int insert(MaintainPlan obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(MaintainPlan obj);
}