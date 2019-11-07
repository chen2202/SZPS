package com.szps.web.controller.dm;

import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.dm.DmLog;
import com.szps.web.service.dm.IDmLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dm/log")
public class DmLogController extends BaseController{

    private String prefix = "dm/log";

    @Autowired
    private IDmLogService logService;
	
	@GetMapping()
    public String show()
    {
        return prefix + "/log";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmLog dmLog)
    {
        startPage();
        List<DmLog> list = logService.selectLogList(dmLog);
        return getDataTable(list);
    }
	
}
