package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbFeedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbFeedbackMapper {

    int deleteByPrimaryKey(String feedbackId);

    int insert(TbFeedback record);

    TbFeedback selectByPrimaryKey(String feedbackId);

    List<TbFeedback> selectAll();

    int updateByPrimaryKey(TbFeedback record);

    List<TbFeedback> selectFeedbackList(TbFeedback record);

    int deleteTaskByIds(Long[] ids);

    int Checkdfb(String feedbackId);
    int checkTask(String taskNumber);

    int countMonthTbFeedback(@Param("taskRegion") String taskRegion , @Param("taskStreet") String taskStreet, @Param("feedbackTime") String feedbackTime);
    int countTbFeedback(@Param("taskRegion") String taskRegion , @Param("taskStreet") String taskStreet, @Param("feedbackTime") String feedbackTime);
}