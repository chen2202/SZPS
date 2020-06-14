package com.szps.web.controller.dm;


import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.framework.util.ShiroUtils;
import com.szps.web.domain.dm.DmData;
import com.szps.web.service.dm.IDmDataService;
import com.szps.web.service.dm.IDmPerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dm/my")
public class DmMyController extends BaseController {

    @Autowired
    private IDmDataService dataService;

    private String prefix = "dm/my";

    @Autowired
    private IDmPerService perService;

    @GetMapping()
    public String show()
    {
        return prefix + "/my";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmData dmData)
    {
        startPage();
        Long per_userId = ShiroUtils.getUserId();
         //通过用户id查询用户有权访问的资料
        return getDataTable(perService.selectDataListByUserId(dmData,per_userId));
    }

}
