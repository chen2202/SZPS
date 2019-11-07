package com.szps.web.controller.event;

import java.text.SimpleDateFormat;
import java.util.*;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.event.EventSend;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.service.event.IEventSubmitService;

/**
 * 污水厂事件Controller
 *
 * @author HJR
 * @date 2019-10-25
 */
@Controller
@RequestMapping("/event/submit")
public class EventSubmitController extends BaseController {
    private String prefix = "event/submit";

    @Autowired
    private IEventSubmitService eventSubmitService;

    @RequiresPermissions("event:submit:view")
    @GetMapping()
    public String submit(Model model) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code_type", "receiveOrderStatus");
        List<EventSend> emailList = eventSubmitService.getEventSendEmail();
        model.addAttribute("emailList", emailList);
        return prefix + "/submit";
    }

    /**
     * 查询污水厂事件列表
     */
    @RequiresPermissions("event:submit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EventSubmit eventSubmit) {
        startPage();
        List<EventSubmit> list = eventSubmitService.selectEventSubmitList(eventSubmit);
        return getDataTable(list);
    }


    @GetMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(EventSubmit eventSubmit) {
        startPage();
        List<EventSubmit> list = eventSubmitService.selectEventSubmitList(eventSubmit);
        return getDataTable(list);
    }

    /**
     * 导出污水厂事件列表
     */
    @RequiresPermissions("event:submit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EventSubmit eventSubmit) {
        List<EventSubmit> list = eventSubmitService.selectEventSubmitList(eventSubmit);
        ExcelUtil<EventSubmit> util = new ExcelUtil<EventSubmit>(EventSubmit.class);
        return util.exportExcel(list, "submit");
    }

    /**
     * 新增污水厂事件
     */
    @GetMapping("/add")
    public String add(Model model, ModelMap mmap,Map<String,String> map) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code_type", "receiveOrderStatus");
        List<EventSend> emailList = eventSubmitService.getEventSendEmail();
        for (int i = 0; i < emailList.size()-1; i++) {
            for (int j = emailList.size()-1; j > i; j--) {
                if (emailList.get(j).getEventAttribute().equals(emailList.get(i).getEventAttribute())) {
                    emailList.remove(j);
                }
            }
        }
        model.addAttribute("emailList", emailList);
        SysUser user = ShiroUtils.getSysUser();
        EventSubmit eventSubmit=new EventSubmit();
        eventSubmit.setEventCreateuser(user.getUserName());
        mmap.put("user",eventSubmit);
        return prefix + "/add";
    }

    /**
     * 新增保存污水厂事件
     */
    @RequiresPermissions("event:submit:add")
    @Log(title = "污水厂事件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EventSubmit eventSubmit) {
        eventSubmit.setEventStatus("未发送");
        return toAjax(eventSubmitService.insertEventSubmit(eventSubmit));
    }

    /**
     * 修改污水厂事件
     */
    @GetMapping("/edit/{eventSid}")
    public String edit(@PathVariable("eventSid") Integer eventSid, ModelMap mmap, Model model) {
        EventSubmit eventSubmit = eventSubmitService.selectEventSubmitById(eventSid);
        mmap.put("eventSubmit", eventSubmit);
        List<EventSend> emailList = eventSubmitService.getEventSendEmail();
        for (int i = 0; i < emailList.size()-1; i++) {
            for (int j = emailList.size()-1; j > i; j--) {
                if (emailList.get(j).getEventAttribute().equals(emailList.get(i).getEventAttribute())) {
                    emailList.remove(j);
                }
            }
        }
        model.addAttribute("emailList", emailList);
        return prefix + "/edit";
    }

    /**
     * 修改保存污水厂事件
     */
    @RequiresPermissions("event:submit:edit")
    @Log(title = "污水厂事件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EventSubmit eventSubmit) {
        return toAjax(eventSubmitService.updateEventSubmit(eventSubmit));
    }

    /**
     * 删除污水厂事件
     */
    @RequiresPermissions("event:submit:remove")
    @Log(title = "污水厂事件", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(eventSubmitService.deleteEventSubmitByIds(ids));
    }

    /**
     * 显示详细基本信息
     */

    @GetMapping("/detail/{eventSid}")
    public String detail(@PathVariable("eventSid") Integer eventSid, ModelMap mmap) {

        EventSubmit eventSubmit = eventSubmitService.selectEventSubmitById(eventSid);
        mmap.put("eventSubmit", eventSubmit);
        return prefix + "/detail";
    }

}
