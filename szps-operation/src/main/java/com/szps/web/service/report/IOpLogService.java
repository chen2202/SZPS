package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.OpLog;

/**
 *日报   服务层
 * 
 * @author Jack
 */
public interface IOpLogService
{

    /**
     * 查询参数配置列表
     * 
     * @param config 参数配置信息
     * @return 参数配置集合
     */
	public List<OpLog> selectReportList(OpLog report);

	public OpLog selectReportById(Long id);

	public int insertReport(OpLog report);

	public int deleteReportById(Long id);

	public int updateReport(OpLog report);

	public int deleteReportByIds(String ids);
}
