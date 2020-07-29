package com.szps.web.mapper.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szps.web.domain.report.DayReportW;

public interface DayReportWMapper {

	public List<DayReportW> selectList(DayReportW obj);
	public List<DayReportW> selectListBetween(@Param("dtype") String dtype,@Param("startTime1") String startTime1,@Param("endTime1") String endTime1);
	public List<DayReportW> selectListForYear(@Param("dtype") String dtype,@Param("startTime1") String startTime1,@Param("endTime1") String endTime1);

	public DayReportW selectById(Long id);

	public int insert(DayReportW obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(DayReportW obj);
}