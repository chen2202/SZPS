package com.szps.web.controller.dm;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.web.domain.dm.DmPermission;
import com.szps.web.domain.dm.DmUDP;
import com.szps.web.service.dm.IDmPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/dm/permission")
public class DmPermissionController extends BaseController {

    @Autowired
    private IDmPerService perService;

    private String prefix = "dm/permission";

    @GetMapping()
    public String show()
    {
        return prefix + "/permission";
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
    public TableDataInfo list(DmUDP udp)
    {
        startPage();
        List<DmUDP> list = perService.selectNotApprovalPerList(udp);
        return getDataTable(list);
    }

    /**
     * 审批结果集合--->已通过
     * */
    @PostMapping("/pass")
    @ResponseBody
    public TableDataInfo pass(DmUDP udp)
    {
        startPage();
        List<DmUDP> list = perService.selectPassPerList(udp);
        return getDataTable(list);
    }


    /**
     * 审批结果集合--->驳回
     */
    @PostMapping("/reject")
    @ResponseBody
    public TableDataInfo reject(DmUDP udp)
    {
        startPage();
        List<DmUDP> list = perService.selectRejectPerList(udp);
        return getDataTable(list);
    }

    /**
     * 保存资料权限申请
     */
    @Log(title = "资料权限申请", businessType = BusinessType.INSERT)
    @PostMapping("/getPermission/{dataId}")
    @ResponseBody
    public AjaxResult getPermissionSave(DmPermission per){
        Long userId = ShiroUtils.getUserId();

        //如果用户不具有该资料的访问权限再提交申请
        if(perService.checkPerExist(per.getDataId(),userId)<1){
            per.setUserId(ShiroUtils.getUserId());
            per.setPerStatus("0");
            return toAjax(perService.insertPer(per));
        }else{
            return error("您已具有该资料访问权限,请勿重复申请!");
        }
    }


    /**
     * 资料权限状态修改
     */
    @Log(title = "资料权限审批", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(DmUDP udp)
    {
        return toAjax(perService.changeStatus(udp.getPerId(),udp.getPerStatus()));
    }

    /**
     * 资料权限状态修改(全部)
     */
    @Log(title = "资料权限审批", businessType = BusinessType.UPDATE)
    @PostMapping("/passAll")
    @ResponseBody
    public AjaxResult passAll(String ids)
    {
        try
        {
            perService.changeStatusByIds(ids,"1");
            return success();
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 资料权限状态修改(全部)
     */
    @Log(title = "资料权限审批", businessType = BusinessType.UPDATE)
    @PostMapping("/rejectAll")
    @ResponseBody
    public AjaxResult rejectAll(String ids)
    {
        try
        {
            perService.changeStatusByIds(ids,"2");
            return success();
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     *删除资料权限审批记录(取消用户资料访问权限)
     */
    @Log(title = "取消用户资料访问权限", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(perService.deletePerByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
