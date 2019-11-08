package com.szps.web.service.event;

import com.szps.web.domain.event.WeChatUser;

public interface IWeChatService {

    public WeChatUser getLogin(WeChatUser user);
}
