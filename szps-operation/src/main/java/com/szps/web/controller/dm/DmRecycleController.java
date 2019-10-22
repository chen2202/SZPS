package com.szps.web.controller.dm;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.web.domain.dm.DmData;
import com.szps.web.service.dm.IDmAuditService;
import com.szps.web.service.dm.IDmDataService;
import com.szps.web.service.dm.IDmPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资料回收站
 *
 * @author vic
 *
 */
@Controller
@RequestMapping("/dm/recycle")
public class DmRecycleController extends BaseController {

    @Autowired
    private IDmDataService dataService;

    @Autowired
    private IDmAuditService auditService;

    @Autowired
    private IDmPerService perService;

    private String prefix = "dm/recycle";

    @GetMapping()
    public String show()
    {
        return prefix + "/recycle";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmData dmData)
    {
        startPage();
        List<DmData> list = dataService.selectDeletedDataList(dmData);
        return getDataTable(list);
    }

    /**
     *恢复资料
     */
    @Log(title = "恢复规划资料", businessType = BusinessType.UPDATE)
    @PostMapping("/recovery")
    @ResponseBody
    public AjaxResult recovery(String ids)
    {
        try
        {
            return toAjax(dataService.changeDataFlagByIds(ids,"0"));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     *删除资料
     */
    @Log(title = "删除规划资料", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            auditService.deleteAuditByDataIds(ids);
            perService.deletePerByDataIds(ids);
            return toAjax(dataService.deleteDataByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

}
