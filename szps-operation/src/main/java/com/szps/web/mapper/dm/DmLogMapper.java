package com.szps.web.mapper.dm;

import com.szps.web.domain.dm.DmLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmLogMapper {

    /**
     * 根据条件分页查询日志列表
     *
     * @param dmLog 操作日志信息
     * @return 操作日志信息信息集合信息
     */
    public List<DmLog> selectLogList(DmLog dmLog);



}
