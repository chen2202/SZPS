package com.szps.web.mapper.event;

import com.szps.web.domain.event.EventEmail;
import com.szps.web.domain.event.EventSubmit;

import java.util.List;

/**
 * 负责人邮箱信息Mapper接口
 *
 * @author HJR
 * @date 2019-11-05
 */
public interface EventEmailMapper
{
    /**
     * 查询负责人邮箱信息
     *
     * @param sid 负责人邮箱信息ID
     * @return 负责人邮箱信息
     */
    public EventEmail selectEventEmailById(Long sid);

    /**
     * 查询负责人邮箱信息列表
     *
     * @param eventEmail 负责人邮箱信息
     * @return 负责人邮箱信息集合
     */
    public List<EventEmail> selectEventEmailList(EventEmail eventEmail);

    /**
     * 新增负责人邮箱信息
     *
     * @param eventEmail 负责人邮箱信息
     * @return 结果
     */
    public int insertEventEmail(EventEmail eventEmail);

    /**
     * 修改负责人邮箱信息
     *
     * @param eventEmail 负责人邮箱信息
     * @return 结果
     */
    public int updateEventEmail(EventEmail eventEmail);

    /**
     * 删除负责人邮箱信息
     *
     * @param sid 负责人邮箱信息ID
     * @return 结果
     */
    public int deleteEventEmailById(Long sid);

    /**
     * 批量删除负责人邮箱信息
     *
     * @param sids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEventEmailByIds(String[] sids);

    /**
     * 修改状态
     */
    public  int updateEventStatus(EventSubmit eventSubmit);
}
