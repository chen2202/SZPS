package com.szps.web.controller.dm;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.core.text.Convert;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.dm.DmAudit;
import com.szps.web.domain.dm.DmCost;
import com.szps.web.service.dm.IDmAuditService;
import com.szps.web.service.dm.IDmCostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;


/**
 * 污水处理费资料管理
 *
 * @author vic
 *
 */
@Controller
@RequestMapping("/dm/cost")
public class DmCostController extends BaseController {

    private String prefix = "dm/cost";

    @Autowired
    private IDmCostService costService;

    @Autowired
    private DmFileController dmFileController;

    @Autowired
    private IDmAuditService auditService;

    @GetMapping()
    public String show()
    {
        return prefix + "/cost";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmCost dmCost) throws Exception{
        if(sql_inj(dmCost.getCostFactory())||sql_inj(dmCost.getCostPunishReason()))
        {
            throw new Exception("输入字符非法！！");
        }

        startPage();
        List<DmCost> list = costService.selectCostList(dmCost);
        return getDataTable(list);
    }

    /**
     *
     * 添加污水处理费资料
     *
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request)
    {
        return prefix + "/add";
    }


    /**
     * 新增资料
     */
    @Log(title = "添加污水费资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(DmCost dmCost, @RequestParam("file") MultipartFile [] file) throws IOException {

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        dmCost.setCostUuid(uuid);
        costService.insertCost(dmCost);

        long id = dmCost.getCostId();

        dmFileController.upload(file, uuid);
        // 新添加的资料都是未审批状态，存在审批表里
        DmAudit dmAudit = new DmAudit();
        dmAudit.setDataId(id);
        dmAudit.setAuditStatus("1");
        auditService.insertAudit(dmAudit);

        return success();
    }


    /**
     *删除资料
     */
    @Log(title = "删除污水费资料", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @Transactional
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        Long[] costIds = Convert.toLongArray(ids);
        auditService.deleteAuditByDataIds(ids);
        return toAjax(costService.deleteCostByIds(costIds));
    }

    /**
     * 修改资料
     */
    @GetMapping("/edit/{costId}")
    public String edit(@PathVariable("costId") Long costId, ModelMap mmap)
    {
        DmCost cost = costService.selectCostById(costId);
        mmap.put("cost",cost);
        return prefix + "/edit";
    }

    /**
     * 修改污水费资料
     */
    @Log(title = "修改污水费资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DmCost dmCost)
    {
        return toAjax(costService.updateCost(dmCost));
    }

    public static boolean sql_inj(String str){
        if (StringUtils.isEmpty(str)) {
            return false;
        }

        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";

        String inj_stra[] = inj_str.split("|");

        for (String anInj_stra : inj_stra) {

            if (str.contains(anInj_stra)) {
                return true;
            }
        }
        return false;
    }

    @Log(title = "资料导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("dm:data:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DmCost dmCost)
    {
        List<DmCost> list = costService.selectCostList(dmCost);
        ExcelUtil<DmCost> util = new ExcelUtil<DmCost>(DmCost.class);
        return util.exportExcel(list, "资料数据");
    }
}
