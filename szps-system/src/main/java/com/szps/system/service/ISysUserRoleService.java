package com.szps.system.service;

import com.szps.system.domain.SysUserRole;

public interface ISysUserRoleService {
    /**
     * 通过用户Id获取角色Id
     * @param sysUserRole
     * @return
     */
    public SysUserRole getSysUserRole(SysUserRole sysUserRole);
}
