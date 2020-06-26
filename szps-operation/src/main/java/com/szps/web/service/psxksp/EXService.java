package com.szps.web.service.psxksp;


import com.szps.web.domain.psxksp.EX_GDBS_SB;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface EXService
{

   // public List<TbTask> selectTaskList(TbTask tbTask);


   // public List<TbTask> selectTaskByTaskNumber(String taskName);


    public List<EX_GDBS_SB> selectTaskAll();

    public List<EX_GDBS_SB> selectTaskBytime(String BYZD4);
    public EX_GDBS_SB selectById(String sblsh);
    public List<EX_GDBS_SB> selectTaskWaiting(EX_GDBS_SB exGdbsSb);
    public List<EX_GDBS_SB> selectTaskDone(EX_GDBS_SB exGdbsSb);

    int updateEx(EX_GDBS_SB ex);

    int selectSpCountAll(String years);
    String selectWsCountAll(String years);
    String selectYsCountAll(String years);



}
