package com.szps.web.controller.wechat;


import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin/login")
public class LoginController {

    @PostMapping(value = "getLogin")
    @ResponseBody
    public String getLogin(){

        SysUser sysUser= ShiroUtils.getSysUser();

       String name= sysUser.getRemark();

       return name;
    }
}
