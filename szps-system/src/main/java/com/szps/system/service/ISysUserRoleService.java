package com.szps.system.service;

import com.szps.system.domain.SysUserRole;

import java.util.List;

public interface ISysUserRoleService {
    /**
     * 通过用户Id获取角色Id
     * @param sysUserRole
     * @return
     */
    public List<SysUserRole> getSysUserRole(SysUserRole sysUserRole);
}
