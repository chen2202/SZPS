package com.szps.web.mapper.psxksp;


import com.szps.web.domain.psxksp.EX_GDBS_SB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EXMapper {

   // int deleteByPrimaryKey(String taskNumber);

    //int insert(TbTask record);

   // TbTask selectByPrimaryKey(String taskNumber);

    List<EX_GDBS_SB> selectAll();

    EX_GDBS_SB selectById(String sblsh);
    //int updateByPrimaryKey(TbTask record);

   // List<TbTask> selectTaskList(TbTask task);

   // List<TbTask> selectTaskByTaskName(String taskName);

   // int deleteTaskByIds(Long[] ids);
   List<EX_GDBS_SB> selectTaskBytime(String BYZD1);
   List<EX_GDBS_SB> selectTaskWaiting(EX_GDBS_SB exGdbsSb);
   List<EX_GDBS_SB> selectTaskDone(EX_GDBS_SB exGdbsSb);


    int updateEx(EX_GDBS_SB ex);

    int selectSpCountAll(@Param("years") String years);
    String selectWsCountAll(@Param("years") String years);
    String selectYsCountAll(@Param("years") String years);
}