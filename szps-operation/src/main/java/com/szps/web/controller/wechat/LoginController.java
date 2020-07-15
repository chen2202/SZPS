package com.szps.web.controller.wechat;


import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysRole;
import com.szps.system.domain.SysUser;
import com.szps.system.domain.SysUserRole;
import com.szps.system.service.ISysDeptService;
import com.szps.system.service.ISysRoleService;
import com.szps.system.service.ISysUserRoleService;
import com.szps.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


//    @PostMapping(value = "getLogin")
//    @ResponseBody
//    public Object getLogin() {
//
//        SysUser sysUser = ShiroUtils.getSysUser();
//
//
//        SysUserRole sysUserRole = new SysUserRole();
//        sysUserRole.setUserId(sysUser.getUserId());
//
//        SysUserRole sysUserRole1 = iSysUserRoleService.getSysUserRole(sysUserRole);
//        SysRole sysRole = roleService.selectRoleById(sysUserRole1.getUserId());
//
//        SysDept sysDept = iSysDeptService.selectDeptById(sysUser.getDeptId());
//
//        if (sysDept.getDeptName().contains("龙华区")) {
//            return "龙华区";
//        } else if (sysDept.getDeptName().contains("龙岗区")) {
//            return "龙岗区";
//        } else if (sysDept.getDeptName().contains("大鹏新区")){
//            return "大鹏新区";
//        }else {
//            return sysDept;
//        }
//
//    }
}
