package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.DayReport;

/**
 * 日报 服务层
 * 
 * @author Jack
 */
public interface IDayReportService {

	/**
	 * 查询参数配置列表
	 * 
	 * @param config 参数配置信息
	 * @return 参数配置集合
	 */
	public List<DayReport> selectReportList(DayReport dayReport);

	public DayReport selectReportById(Long id);

	public int insertReport(DayReport dayReport);

	public int deleteReportById(Long id);

	public int updateReport(DayReport report);

	public int deleteReportByIds(String ids);
}
