package com.szps.web.controller.system;

import java.util.ArrayList;
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
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
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
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenuAll(user.getUserId());
        List<SysMenu> sysMenus = new ArrayList<SysMenu>();
        for (SysMenu sysMenu : menus) {
			if (sysMenu!=null & sysMenu.getPerms()!=null & sysMenu.getPerms().startsWith("system:subsys:view") ) {
				sysMenus.add(sysMenu);
			}
		}
        mmap.put("version", Global.getVersion());
        if (sysMenus!=null & !sysMenus.isEmpty()) {
        	mmap.put("menus", sysMenus);
		}
        menus.clear();
        return "main";
    }
   /** 
    // 系统介绍
    @GetMapping("/system/subsys")
    public String subsys(ModelMap mmap)
    {
    	 // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenuAll(user.getUserId());
        List<SysMenu> sysMenus = new ArrayList<SysMenu>();
        for (SysMenu sysMenu : menus) {
			if (sysMenu!=null & sysMenu.getPerms()!=null & sysMenu.getPerms().startsWith("system:subsys:view") ) {
				sysMenus.add(sysMenu);
			}
		}
        mmap.put("version", Global.getVersion());
        if (sysMenus!=null & !sysMenus.isEmpty()) {
        	mmap.put("menus", sysMenus);
		}
        menus.clear();
        return "subsysnav";
    }
    **/
}
