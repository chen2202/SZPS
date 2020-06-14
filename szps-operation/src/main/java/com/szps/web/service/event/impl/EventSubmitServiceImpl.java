package com.szps.web.service.event.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.event.EventSubmitMapper;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.service.event.IEventSubmitService;
import com.szps.common.core.text.Convert;

/**
 * 突发事件上传Service业务层处理
 * 
 * @author HJR
 * @date 2020-06-06
 */
@Service
public class EventSubmitServiceImpl implements IEventSubmitService 
{
    @Autowired
    private EventSubmitMapper eventSubmitMapper;

    /**
     * 查询突发事件上传
     * 
     * @param eventId 突发事件上传ID
     * @return 突发事件上传
     */
    @Override
    public EventSubmit selectEventSubmitById(Integer eventId)
    {
        return eventSubmitMapper.selectEventSubmitById(eventId);
    }

    /**
     * 查询突发事件上传列表
     * 
     * @param eventSubmit 突发事件上传
     * @return 突发事件上传
     */
    @Override
    public List<EventSubmit> selectEventSubmitList(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.selectEventSubmitList(eventSubmit);
    }

    /**
     * 新增突发事件上传
     * 
     * @param eventSubmit 突发事件上传
     * @return 结果
     */
    @Override
    public int insertEventSubmit(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.insertEventSubmit(eventSubmit);
    }

    /**
     * 修改突发事件上传
     * 
     * @param eventSubmit 突发事件上传
     * @return 结果
     */
    @Override
    public int updateEventSubmit(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.updateEventSubmit(eventSubmit);
    }

    /**
     * 删除突发事件上传对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEventSubmitByIds(String ids)
    {
        return eventSubmitMapper.deleteEventSubmitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除突发事件上传信息
     * 
     * @param eventId 突发事件上传ID
     * @return 结果
     */
    @Override
    public int deleteEventSubmitById(Integer eventId)
    {
        return eventSubmitMapper.deleteEventSubmitById(eventId);
    }
}
