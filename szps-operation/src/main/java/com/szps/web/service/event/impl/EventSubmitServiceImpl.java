package com.szps.web.service.event.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.event.EventSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.event.EventSubmitMapper;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.service.event.IEventSubmitService;


/**
 * 污水厂事件Service业务层处理
 *
 * @author HJR
 * @date 2019-10-25
 */
@Service
public class EventSubmitServiceImpl implements IEventSubmitService
{
    @Autowired
    private EventSubmitMapper eventSubmitMapper;

    /**
     * 查询污水厂事件
     *
     * @param eventSid 污水厂事件ID
     * @return 污水厂事件
     */
    @Override
    public EventSubmit selectEventSubmitById(Integer eventSid)
    {
        return eventSubmitMapper.selectEventSubmitById(eventSid);
    }

    /**
     * 查询污水厂事件列表
     *
     * @param eventSubmit 污水厂事件
     * @return 污水厂事件
     */
    @Override
    public List<EventSubmit> selectEventSubmitList(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.selectEventSubmitList(eventSubmit);
    }

    /**
     * 新增污水厂事件
     *
     * @param eventSubmit 污水厂事件
     * @return 结果
     */
    @Override
    public int insertEventSubmit(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.insertEventSubmit(eventSubmit);
    }

    /**
     * 修改污水厂事件
     *
     * @param eventSubmit 污水厂事件
     * @return 结果
     */
    @Override
    public int updateEventSubmit(EventSubmit eventSubmit)
    {
        return eventSubmitMapper.updateEventSubmit(eventSubmit);
    }

    /**
     * 删除污水厂事件对象
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
     * 删除污水厂事件信息
     *
     * @param eventSid 污水厂事件ID
     * @return 结果
     */
    @Override
    public int deleteEventSubmitById(Integer eventSid)
    {
        return eventSubmitMapper.deleteEventSubmitById(eventSid);
    }



    /**
     * 查询所有事件负责人邮箱
     */
    public List<EventSend> getEventSendEmail(){
        return eventSubmitMapper.getEventSendEmail();
    }
}
