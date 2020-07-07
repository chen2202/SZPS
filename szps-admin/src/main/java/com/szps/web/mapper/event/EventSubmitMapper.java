package com.szps.web.mapper.event;

import com.szps.web.domain.event.EventPicture;
import com.szps.web.domain.event.EventSubmit;

import java.util.List;

/**
 * 突发事件上传Mapper接口
 *
 * @author HJR
 * @date 2020-06-06
 */
public interface EventSubmitMapper
{
    /**
     * 查询突发事件上传
     *
     * @param eventId 突发事件上传ID
     * @return 突发事件上传
     */
    public EventSubmit selectEventSubmitById(Integer eventId);

    /**
     * 查询突发事件上传列表
     *
     * @param eventSubmit 突发事件上传
     * @return 突发事件上传集合
     */
    public List<EventSubmit> selectEventSubmitList(EventSubmit eventSubmit);

    /**
     * 新增突发事件上传
     *
     * @param eventSubmit 突发事件上传
     * @return 结果
     */
    public int insertEventSubmit(EventSubmit eventSubmit);

    /**
     * 修改突发事件上传
     *
     * @param eventSubmit 突发事件上传
     * @return 结果
     */
    public int updateEventSubmit(EventSubmit eventSubmit);

    /**
     * 删除突发事件上传
     *
     * @param eventId 突发事件上传ID
     * @return 结果
     */
    public int deleteEventSubmitById(Integer eventId);

    /**
     * 批量删除突发事件上传
     *
     * @param eventIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEventSubmitByIds(String[] eventIds);

    /**
     * 新增图片上传
     * @param eventPicture
     * @return
     */
    public int insertEventPicture(EventPicture eventPicture);

    /**
     * 获取图片
     * @param eventPicture
     * @return
     */
    public  List<EventPicture> getEventPictures(EventPicture eventPicture);
}
