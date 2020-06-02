package com.szps.web.service.supervise;


import com.szps.web.domain.supervise.TbTask;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface TaskService
{

    public List<TbTask> selectTaskList(TbTask tbTask);


    public List<TbTask> selectTaskByTaskNumber(String taskName);


    public List<TbTask> selectTaskAll();


    public TbTask selectTaskById(String taskNumber);


    public List<TbTask> selectTaskRandom();

    public int deleteTaskById(String taskNumber);

    /**
     * 批量删除角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteTaskByIds(String ids) throws Exception;


    public int insertTask(TbTask tbTask);

    public int updateTask(TbTask tbTask);

    public  int checkTask(String taskNumber);

    public int selectTaskCount(String taskRegion, String taskStreet, String taskTime);

    public int selectTaskCountAll();
    public int selectTaskCountComplete();

    public int selectTaskCountAllWithKey(TbTask task);
    public int selectTaskCountCompleteWithKey(TbTask task);

    public int selectMonthTaskCount(String taskRegion, String taskStreet, String taskTime);
}
