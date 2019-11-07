package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.mapper.supervise.TbStaffMapper;
import com.szps.web.mapper.supervise.TbTaskMapper;
import com.szps.web.service.supervise.StaffService;
import com.szps.web.service.supervise.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TbTaskMapper tbTaskMapper;

    @Override
    public List<TbTask> selectTaskList(TbTask tbTask) {
        return tbTaskMapper.selectTaskList(tbTask);
    }

    @Override
    public List<TbTask> selectTaskByTaskNumber(String taskName) {
        return tbTaskMapper.selectTaskByTaskName(taskName);
    }

    @Override
    public List<TbTask> selectTaskAll() {
        return tbTaskMapper.selectAll();
    }

    @Override
    public TbTask selectTaskById(String taskNumber) {
        return tbTaskMapper.selectByPrimaryKey(taskNumber);
    }

    @Override
    public List<TbTask> selectTaskRandom() {
        return tbTaskMapper.selectTaskRandom();
    }

    @Override
    public int deleteTaskById(String taskNumber) {
        return tbTaskMapper.deleteByPrimaryKey(taskNumber);
    }

    @Override
    public int deleteTaskByIds(String ids) throws Exception {
        Long[] Ids = Convert.toLongArray(ids);
        return tbTaskMapper.deleteTaskByIds(Ids);

    }

    @Override
    public int insertTask(TbTask tbTask) {
        return tbTaskMapper.insert(tbTask);
    }

    @Override
    public int updateTask(TbTask tbTask) {
        return tbTaskMapper.updateByPrimaryKey(tbTask);
    }

    @Override
    public int checkTask(String taskNumber) {
        return tbTaskMapper.CheckdTask(taskNumber);
    }

    @Override
    public int selectTaskCount(String taskRegion, String taskStreet, String taskTime) {
        return tbTaskMapper.selectTaskCount(taskRegion,taskStreet,taskTime);
    }

    @Override
    public int selectMonthTaskCount(String taskRegion, String taskStreet, String taskTime) {
        return tbTaskMapper.selectMonthTaskCount(taskRegion,taskStreet,taskTime);
    }
}
