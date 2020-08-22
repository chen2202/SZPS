package com.szps.web.controller.dm;

import com.szps.common.annotation.Log;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysUserService;
import com.szps.web.domain.dm.DmAudit;
import com.szps.web.domain.dm.DmData;
import com.szps.web.service.dm.IDmAuditService;
import com.szps.web.service.dm.IDmDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.szps.common.core.controller.BaseController;

import java.util.List;

@Controller
@RequestMapping("/dm/audit")
public class DmAuditController extends BaseController{
	
    private String prefix = "dm/audit";

    @Autowired
    private IDmDataService dataService;

    @Autowired
    private IDmAuditService auditService;

    @Autowired
    private ISysUserService userService;
	
	@GetMapping()
    public String show()
    {
        return prefix + "/audit";
    }

    @GetMapping("/pass")
    public String showPass()
    {
        return prefix + "/pass";
    }

    @GetMapping("/reject")
    public String showReject()
    {
        return prefix + "/reject";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmData dmData)
    {
        startPage();
        List<DmData> list = dataService.selectApprovalDataList(dmData);
        return getDataTable(list);
    }


    /**
     * 审批状态修改
     */
    @Log(title = "修改审批状态", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(DmData dmData)
    {
        SysUser sysUser = userService.selectUserById(ShiroUtils.getUserId());
        if(sysUser!=null){
            DmAudit dmAudit = new DmAudit();
            dmAudit.setDataId(dmData.getDataId());
            dmAudit.setUserId(ShiroUtils.getUserId());
            dmAudit.setUserName(sysUser.getUserName());
            dmAudit.setAuditStatus(dmData.getAudit().getAuditStatus());
            dmAudit.setAuditResult(dmData.getAudit().getAuditResult());
            auditService.changeStatus(dmAudit);
            return success();
        }
        return error();
    }
}
