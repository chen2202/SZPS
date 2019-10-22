package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbFeedback;
import com.szps.web.mapper.supervise.TbFeedbackMapper;
import com.szps.web.service.supervise.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiseImpl implements FeedbackService{
    @Autowired
    TbFeedbackMapper feedbackMapper;

    @Override
    public List<TbFeedback> selectTaskList(TbFeedback tbFeedback) {
        return feedbackMapper.selectFeedbackList(tbFeedback);
    }

    @Override
    public List<TbFeedback> selectTaskAll() {
        return null;
    }

    @Override
    public TbFeedback selectTaskById(String feedbackId) {
        return feedbackMapper.selectByPrimaryKey(feedbackId);
    }

    @Override
    public int deleteTaskById(String feedbackId) {
        return 0;
    }

    @Override
    public int deleteTaskByIds(String ids) throws Exception {
        Long[] Ids = Convert.toLongArray(ids);
        return feedbackMapper.deleteTaskByIds(Ids);
    }

    @Override
    public int insertTask(TbFeedback tbFeedback) {
        return feedbackMapper.insert(tbFeedback);
    }

    @Override
    public int updateTask(TbFeedback tbFeedback) {
        return 0;
    }

    @Override
    public int checkfb(String feedbackId) {
        return feedbackMapper.Checkdfb(feedbackId);
    }

    @Override
    public int countTbFeedback(String taskRegion, String taskStreet, String feedbackTime) {
        return feedbackMapper.countTbFeedback(taskRegion,taskStreet,feedbackTime);
    }

    @Override
    public int countMonthTbFeedback(String taskRegion, String taskStreet, String feedbackTime) {
        return feedbackMapper.countMonthTbFeedback(taskRegion,taskStreet,feedbackTime);
    }

    @Override
    public int checkTaskUnique(String taskNumber) {

            return feedbackMapper.checkTask(taskNumber);
    }
}
