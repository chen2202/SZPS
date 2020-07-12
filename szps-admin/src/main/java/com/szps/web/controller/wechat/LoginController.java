package com.szps.web.controller.wechat;


import com.szps.common.config.Global;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.*;
import com.szps.system.service.*;
import com.szps.web.domain.mine.mine;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/login")
public class LoginController {

    @Autowired
    private ISysDeptService iSysDeptService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ISysUserRoleService iSysUserRoleService;

    @Autowired
    private ISysAreaService iSysAreaService;


    @PostMapping(value = "getSysRole")
    @ResponseBody
    public Object getSysRole() {

        SysUser sysUser = ShiroUtils.getSysUser();


        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId());

        SysUserRole sysUserRole1 = iSysUserRoleService.getSysUserRole(sysUserRole);
        SysRole sysRole = roleService.selectRoleById(sysUserRole1.getRoleId());


        if (sysRole.getRoleName().contains("水务局人员")) {
            return "水务局人员";
        } else if (sysRole.getRoleName().contains("运营单位")) {
            return "运营单位";
        } else {
            return "业务操作员";
        }
    }

    /**
     * 获取用户所属区域
     *
     * @param sysArea
     * @return
     */
    @PostMapping(value = "getSysDept")
    @ResponseBody
    public Object getSysDept(SysArea sysArea) {

        return getUserArea(sysArea);
    }


    @PostMapping(value = "mine")
    @ResponseBody
    public mine getMine(SysArea sysArea) {


        SysUser sysUser = ShiroUtils.getSysUser();


        SysDept sysDept = iSysDeptService.selectDeptById(sysUser.getDeptId());

        List<String> strings = new ArrayList<>();
        strings.add(sysDept.getDeptName());
        while (true) {

            if (sysDept.getParentId() == 0) {
                break;
            } else {
                sysDept = iSysDeptService.getSysDeptParent(sysDept);
                strings.add(sysDept.getDeptName());
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strings.size() - 1; i >= 0; i--) {
            stringBuffer.append(strings.get(i));
            if (i != 0) {
                stringBuffer.append("-");
            }

        }

        mine mine = new mine();

        mine.setUserId(sysUser.getUserId());
        mine.setUserName(sysUser.getUserName());
        mine.setUserDept(stringBuffer);
        mine.setUserPosition("科长");
        mine.setUserPhone(sysUser.getPhonenumber());
        mine.setUserEmail(sysUser.getEmail());
        mine.setUserArea(getUserArea(sysArea));


        return mine;
    }

    protected String getUserArea(SysArea sysArea) {
        SysUser sysUser = ShiroUtils.getSysUser();

        SysDept sysDept = iSysDeptService.selectDeptById(sysUser.getDeptId());


        List<SysArea> areas = iSysAreaService.selectAreaList(sysArea);

        String userArea = "深圳市";
        for (SysArea sysArea1 : areas) {
            if (sysDept.getParentName().contains(sysArea1.getAreaName())) {
                userArea = sysArea1.getAreaName();
            }
        }
        return userArea;

    }


    @PostMapping(value = "picture")
    @ResponseBody
    public Object getPicture() {
        return Global.getUploadPath();
    }
}
