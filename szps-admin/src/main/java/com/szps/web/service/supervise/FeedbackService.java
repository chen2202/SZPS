package com.szps.web.service.supervise;


import com.szps.web.domain.supervise.TbFeedback;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface FeedbackService
{

    public List<TbFeedback> selectTaskList(TbFeedback tbFeedback);


    public List<TbFeedback> selectTaskAll();


    public TbFeedback selectTaskById(String feedbackId);


    public int deleteTaskById(String feedbackId);

    public int deleteTaskByIds(String ids) throws Exception;

    public int insertTask(TbFeedback tbFeedback);

    public int updateTask(TbFeedback tbFeedback);

    public  int checkfb(String feedbackId);

    public int countTbFeedback(String taskRegion, String taskStreet, String feedbackTime);

    public int countMonthTbFeedback(String taskRegion, String taskStreet, String feedbackTime);


    public  int checkTaskUnique(String taskNumber);
}
