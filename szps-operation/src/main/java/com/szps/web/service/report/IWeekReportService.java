package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.WeekReport;

/**
 *日报   服务层
 * 
 * @author Jack
 */
public interface IWeekReportService
{

    /**
     * 查询参数配置列表
     * 
     * @param config 参数配置信息
     * @return 参数配置集合
     */
	public List<WeekReport> selectReportList(WeekReport report);

	public WeekReport selectReportById(Long id);

	public int insertReport(WeekReport report);

	public int deleteReportById(Long id);

	public int updateReport(WeekReport report);

	public int deleteReportByIds(String ids);
}
