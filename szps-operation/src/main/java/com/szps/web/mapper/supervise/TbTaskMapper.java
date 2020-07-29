package com.szps.web.mapper.supervise;


import com.szps.web.domain.supervise.TaskUncheck;
import com.szps.web.domain.supervise.TbTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTaskMapper {

    int deleteByPrimaryKey(String taskNumber);

    int insert(TbTask record);

    TbTask selectByPrimaryKey(String taskNumber);

    List<TbTask> selectAll();

    int updateByPrimaryKey(TbTask record);

    List<TbTask> selectTaskList(TbTask task);

    List<TbTask> selectTaskByTaskName(String taskName);

    int deleteTaskByIds(Long[] ids);

     List<TbTask> selectTaskRandom();

     int selectTaskCount(@Param("taskRegion") String taskRegion, @Param("taskStreet") String taskStreet, @Param("taskTime") String taskTime);
     int selectMonthTaskCount(@Param("taskRegion") String taskRegion, @Param("taskStreet") String taskStreet, @Param("taskTime") String taskTime);
     int CheckdTask(String taskNumber);

    int selectTaskCountAll();
    int selectTaskCountComplete();
    int selectTaskCountAllWithKey(TbTask task);
    int selectTaskCountCompleteWithKey(TbTask task);

    List<TaskUncheck> selectTaskAllExport();

    List<TaskUncheck> selectTaskAllOldExport(TbTask task);


}