package com.szps.web.service.supervise.Impl;

import com.szps.web.domain.supervise.TbPicture;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.mapper.supervise.TbPictureMapper;
import com.szps.web.service.supervise.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiseImpl implements PictureService {


    @Autowired
    private TbPictureMapper pictureMapper;

    @Override
    public List<TbRule> selectRuleList(TbRule rule) {
        return null;
    }

    @Override
    public List<TbRule> selectRuleAll() {
        return null;
    }

    @Override
    public List<TbPicture> selectPictureById(String pictureNumber) {
        return pictureMapper.selectByPrimaryKey(pictureNumber);
    }

    @Override
    public int deleteRuleById(String ruleNumber) {
        return 0;
    }

    @Override
    public int deleteRuleByIds(String ids) throws Exception {
        return 0;
    }

    @Override
    public int insertRule(TbPicture picture ) {

        return pictureMapper.insert(picture);
    }

    @Override
    public int updateRule(TbRule rule) {
        return 0;
    }

    @Override
    public int checkPicture(String s) {
        return pictureMapper.Checkdpc(s);
    }
}
