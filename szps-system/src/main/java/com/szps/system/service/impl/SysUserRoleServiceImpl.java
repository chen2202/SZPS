package com.szps.system.service.impl;

import com.szps.system.domain.SysUserRole;
import com.szps.system.mapper.SysUserRoleMapper;
import com.szps.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl  implements ISysUserRoleService {


    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /**
     * 通过用户Id获取角色Id
     * @param sysUserRole
     * @return
     */
    public SysUserRole getSysUserRole(SysUserRole sysUserRole){
        return userRoleMapper.getSysUserRole(sysUserRole);
    }
}
