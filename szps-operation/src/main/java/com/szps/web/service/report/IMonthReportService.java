package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.MonthReport;
import com.szps.web.domain.report.MonthReport;

/**
 *日报   服务层
 * 
 * @author Jack
 */
public interface IMonthReportService
{

    /**
     * 查询参数配置列表
     * 
     * @param config 参数配置信息
     * @return 参数配置集合
     */
	public List<MonthReport> selectReportList(MonthReport report);

	public MonthReport selectReportById(Long id);

	public int insertReport(MonthReport report);

	public int deleteReportById(Long id);

	public int updateReport(MonthReport report);

	public int deleteReportByIds(String ids);
}
