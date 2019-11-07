package com.szps.web.controller.event;

import java.util.List;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szps.web.domain.event.EventEmail;
import com.szps.web.service.event.IEventEmailService;

/**
 * 负责人邮箱信息Controller
 *
 * @author HJR
 * @date 2019-11-05
 */
@Controller
@RequestMapping("/event/email")
public class EventEmailController extends BaseController
{
    private String prefix = "event/email";

    @Autowired
    private IEventEmailService eventEmailService;


    @GetMapping()
    public String email()
    {
        return prefix + "/email";
    }

    /**
     * 查询负责人邮箱信息列表
     */
    @RequiresPermissions("event:email:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EventEmail eventEmail)
    {
        startPage();
        List<EventEmail> list = eventEmailService.selectEventEmailList(eventEmail);
        return getDataTable(list);
    }

    /**
     * 导出负责人邮箱信息列表
     */
    @RequiresPermissions("event:email:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EventEmail eventEmail)
    {
        List<EventEmail> list = eventEmailService.selectEventEmailList(eventEmail);
        ExcelUtil<EventEmail> util = new ExcelUtil<EventEmail>(EventEmail.class);
        return util.exportExcel(list, "email");
    }

    /**
     * 新增负责人邮箱信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存负责人邮箱信息
     */
    @RequiresPermissions("event:email:add")
    @Log(title = "负责人邮箱信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EventEmail eventEmail)
    {
        return toAjax(eventEmailService.insertEventEmail(eventEmail));
    }

    /**
     * 修改负责人邮箱信息
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        EventEmail eventEmail = eventEmailService.selectEventEmailById(sid);
        mmap.put("eventEmail", eventEmail);
        return prefix + "/edit";
    }

    /**
     * 修改保存负责人邮箱信息
     */
    @RequiresPermissions("event:email:edit")
    @Log(title = "负责人邮箱信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EventEmail eventEmail)
    {
        return toAjax(eventEmailService.updateEventEmail(eventEmail));
    }

    /**
     * 删除负责人邮箱信息
     */
    @RequiresPermissions("event:email:remove")
    @Log(title = "负责人邮箱信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(eventEmailService.deleteEventEmailByIds(ids));
    }
}
