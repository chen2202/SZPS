package com.szps.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysMenu;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    // 系统首页
    @GetMapping("/index")
    public String OPindex(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        String menuName =Global.getName();
        String subsysFlag =Global.getFlag();
        int parentId = menuService.selectMenuIDByName(menuName);
        List<SysMenu> menus = menuService.selectMenusByUserAndSubsysFlag(user,subsysFlag,parentId);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }
    
    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
    	 // 取身份信息
//        SysUser user = ShiroUtils.getSysUser();
        return "main";
    }
}
