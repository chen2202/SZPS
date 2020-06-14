package com.szps.web.service.event;

import java.util.List;
import com.szps.web.domain.event.EventSubmit;

/**
 * 突发事件上传Service接口
 * 
 * @author HJR
 * @date 2020-06-06
 */
public interface IEventSubmitService 
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
     * 批量删除突发事件上传
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEventSubmitByIds(String ids);

    /**
     * 删除突发事件上传信息
     * 
     * @param eventId 突发事件上传ID
     * @return 结果
     */
    public int deleteEventSubmitById(Integer eventId);
}
