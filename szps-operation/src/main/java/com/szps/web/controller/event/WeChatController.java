package com.szps.web.controller.event;

import com.szps.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "event/wechat")
public class WeChatController extends BaseController {

   @GetMapping(value = "wechat")
    public String getLogin(){
       return "hello world";
   }
}
