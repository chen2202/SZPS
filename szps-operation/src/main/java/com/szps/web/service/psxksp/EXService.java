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


   /* public TbTask selectTaskById(String taskNumber);


    public List<TbTask> selectTaskRandom();

    public int deleteTaskById(String taskNumber);

    *//**
     * 批量删除角色用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     *//*
    public int deleteTaskByIds(String ids) throws Exception;


    public int insertTask(TbTask tbTask);

    public int updateTask(TbTask tbTask);

    public  int checkTask(String taskNumber);

    public int selectTaskCount(String taskRegion, String taskStreet, String taskTime);

    public int selectMonthTaskCount(String taskRegion, String taskStreet, String taskTime);*/
}
