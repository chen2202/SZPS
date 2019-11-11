package com.szps.web.service.supervise.Impl;

import com.szps.web.domain.supervise.TbEnclosure;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.mapper.supervise.TbEnclosureMapper;
import com.szps.web.service.supervise.EnclosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnclosureServiseImpl implements EnclosureService {


    @Autowired
    private TbEnclosureMapper enclosureMapper;

    @Override
    public List<TbEnclosure> selectEnclosureList(TbEnclosure enclosure) {
        return null;
    }

    @Override
    public List<TbEnclosure> selectRuleAll() {
        return null;
    }

    @Override
    public List<TbEnclosure> selectEnclosureById(String feedbackNumber) {
        return enclosureMapper.selectByPrimaryKey(feedbackNumber);
    }

    @Override
    public TbEnclosure selectEnclosureByIds(String enclosureId) {
        return enclosureMapper.selectEnclosureByIds(enclosureId);
    }

    @Override
    public int deleteEnclosureById(String Number) {
        return 0;
    }

    @Override
    public int deleteEnclosureByIds(String ids) throws Exception {
        return 0;
    }

    @Override
    public int insertEnclosure(TbEnclosure enclosure) {
        return enclosureMapper.insert(enclosure);
    }

    @Override
    public int updateEnclosure(TbRule rule) {
        return 0;
    }

    @Override
    public int checkEnclosure(String s) {
        return enclosureMapper.Checkdec(s);
    }
}
