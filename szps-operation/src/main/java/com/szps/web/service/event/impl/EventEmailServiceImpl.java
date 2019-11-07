package com.szps.web.service.event.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.event.EventSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szps.web.mapper.event.EventEmailMapper;
import com.szps.web.domain.event.EventEmail;
import com.szps.web.service.event.IEventEmailService;


/**
 * 负责人邮箱信息Service业务层处理
 *
 * @author HJR
 * @date 2019-11-05
 */
@Service
public class EventEmailServiceImpl implements IEventEmailService
{
    @Autowired
    private EventEmailMapper eventEmailMapper;

    /**
     * 查询负责人邮箱信息
     *
     * @param sid 负责人邮箱信息ID
     * @return 负责人邮箱信息
     */
    @Override
    public EventEmail selectEventEmailById(Long sid)
    {
        return eventEmailMapper.selectEventEmailById(sid);
    }

    /**
     * 查询负责人邮箱信息列表
     *
     * @param eventEmail 负责人邮箱信息
     * @return 负责人邮箱信息
     */
    @Override
    public List<EventEmail> selectEventEmailList(EventEmail eventEmail)
    {
        return eventEmailMapper.selectEventEmailList(eventEmail);
    }

    /**
     * 新增负责人邮箱信息
     *
     * @param eventEmail 负责人邮箱信息
     * @return 结果
     */
    @Override
    public int insertEventEmail(EventEmail eventEmail)
    {
        return eventEmailMapper.insertEventEmail(eventEmail);
    }

    /**
     * 修改负责人邮箱信息
     *
     * @param eventEmail 负责人邮箱信息
     * @return 结果
     */
    @Override
    public int updateEventEmail(EventEmail eventEmail)
    {
        return eventEmailMapper.updateEventEmail(eventEmail);
    }

    /**
     * 删除负责人邮箱信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEventEmailByIds(String ids)
    {
        return eventEmailMapper.deleteEventEmailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除负责人邮箱信息信息
     *
     * @param sid 负责人邮箱信息ID
     * @return 结果
     */
    @Override
    public int deleteEventEmailById(Long sid)
    {
        return eventEmailMapper.deleteEventEmailById(sid);
    }

    /**
     * 修改状态
     */
    public  int updateEventStatus(EventSubmit eventSubmit){
        return eventEmailMapper.updateEventStatus(eventSubmit);
    }

}
