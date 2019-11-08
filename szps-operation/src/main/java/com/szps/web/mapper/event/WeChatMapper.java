package com.szps.web.mapper.event;

import com.szps.web.domain.event.WeChatUser;

public interface WeChatMapper {

    public WeChatUser getLogin(WeChatUser user);
}
