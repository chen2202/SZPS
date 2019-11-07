package com.szps.web.mapper.event;

import com.szps.web.domain.event.EventAll;
import com.szps.web.domain.event.EventSend;
import com.szps.web.domain.event.EventSubmit;
import java.util.List;

/**
 * 污水厂事件Mapper接口
 *
 * @author HJR
 * @date 2019-10-25
 */
public interface EventSubmitMapper
{
    /**
     * 查询污水厂事件
     *
     * @param eventSid 污水厂事件ID
     * @return 污水厂事件
     */
    public EventSubmit selectEventSubmitById(Integer eventSid);

    /**
     * 查询污水厂事件列表
     *
     * @param eventSubmit 污水厂事件
     * @return 污水厂事件集合
     */
    public List<EventSubmit> selectEventSubmitList(EventSubmit eventSubmit);

    /**
     * 新增污水厂事件
     *
     * @param eventSubmit 污水厂事件
     * @return 结果
     */
    public int insertEventSubmit(EventSubmit eventSubmit);

    /**
     * 修改污水厂事件
     *
     * @param eventSubmit 污水厂事件
     * @return 结果
     */
    public int updateEventSubmit(EventSubmit eventSubmit);

    /**
     * 删除污水厂事件
     *
     * @param eventSid 污水厂事件ID
     * @return 结果
     */
    public int deleteEventSubmitById(Integer eventSid);

    /**
     * 批量删除污水厂事件
     *
     * @param eventSids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEventSubmitByIds(String[] eventSids);


    /**
     * 查询所有事件负责人邮箱
     */
    public List<EventSend> getEventSendEmail();

}
