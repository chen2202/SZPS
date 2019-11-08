package com.szps.web.service.event.impl;

import com.szps.web.domain.event.WeChatUser;
import com.szps.web.mapper.event.WeChatMapper;
import com.szps.web.service.event.IWeChatService;
import org.springframework.beans.factory.annotation.Autowired;

public class WeChatServiceImpl implements IWeChatService {

    @Autowired
    WeChatMapper weChatMapper;


    public WeChatUser getLogin(WeChatUser user){
        return weChatMapper.getLogin(user);
    }

}
