package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbEnclosure;

import java.util.List;

public interface TbEnclosureMapper {
    int deleteByPrimaryKey(String enclosureId);

    int insert(TbEnclosure record);

    List<TbEnclosure> selectByPrimaryKey(String feedbackId);

    List<TbEnclosure> selectAll();

    int updateByPrimaryKey(TbEnclosure record);
    int Checkdec(String enclosureId);
}