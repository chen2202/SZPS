package com.szps.web.mapper.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szps.web.domain.report.PumpDetail;

/**
 * 
 */
public interface PumpDetailMapper {
	public List<PumpDetail> selectListByPumpId(@Param(value="pumpid") Long pumpid);

	public int insertReport(PumpDetail report);

	public int deleteByPumpIds(Long[] ids);


	public int updateReport(PumpDetail report);
}