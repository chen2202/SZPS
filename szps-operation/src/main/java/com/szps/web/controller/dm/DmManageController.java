package com.szps.web.controller.dm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * 资料主界面
 */
@Controller
@RequestMapping("/dm/manage")
public class DmManageController {
    /**
     * 规划资料框架界面跳转
     */
    @GetMapping
    public String index(){
        return "/dm/main";
    }
}
