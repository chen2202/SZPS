package com.szps.web.service.dm;

import com.szps.web.domain.dm.DmLog;

import java.util.List;

/**
 * 操作日志业务层
 *
 * @author vic
 */
public interface IDmLogService {

    /**
     * 根据条件分页查询日志列表
     *
     * @param dmLog 操作日志信息
     * @return 操作日志信息信息集合信息
     */
    public List<DmLog> selectLogList(DmLog dmLog);

}
