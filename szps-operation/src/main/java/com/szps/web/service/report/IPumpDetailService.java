package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.PumpDetail;

public interface IPumpDetailService {

	public List<PumpDetail> selectListByPumpId(Long pumpid);

	public int insertReport(PumpDetail report);

	public int deleteByPumpIds(String ids);

	public int updateReport(PumpDetail report);

}
