package com.szps.web.controller.wechat;


import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.check.PlantCheckRecord;
import com.szps.web.domain.drainage.Household;
import com.szps.web.domain.event.EventEmail;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.domain.supervise.TbTaskStaff;
import com.szps.web.service.check.IPlantCheckRecordService;
import com.szps.web.service.drainage.HouseholdService;
import com.szps.web.service.event.IEventSubmitService;
import com.szps.web.service.supervise.StaffService;
import com.szps.web.service.supervise.TaskService;
import com.szps.web.service.supervise.TaskStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WeChatController extends BaseController {

    @Autowired
    private IPlantCheckRecordService plantCheckRecordService;

    @Autowired
    private IEventSubmitService eventSubmitService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private StaffService staffService;

    @Autowired
    private TaskStaffService taskStaffService;



    @PostMapping("/plantadd")
    @ResponseBody
    public AjaxResult plantadd(String plantId, String plantName, String deviceID, String deviceName, String checkID, String sloveRecode, Date checkDate,
                               String Screateuser, Date Screatetime) throws ParseException {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1=sdf.parse(checkDate);
//        Date date2=sdf.parse(Screatetime);
        PlantCheckRecord plantCheckRecord = new PlantCheckRecord(plantId, plantName, deviceID, deviceName, checkID, sloveRecode, checkDate,
                Screateuser, Screatetime);
        return toAjax(plantCheckRecordService.insertPlantCheckRecord(plantCheckRecord));

    }


    @PostMapping("/eventsubmit")
    @ResponseBody
    public AjaxResult eventsubmit(String eventname, String eventplace, Date eventtime, String eventcontent, String eventattribute
            , String eventcreateuser, Date eventcreatetime) throws ParseException {

        EventSubmit eventSubmit = new EventSubmit(eventname, eventplace, eventtime, eventcontent, eventattribute, eventcreateuser, eventcreatetime, "未发送");
        return toAjax(eventSubmitService.insertEventSubmit(eventSubmit));
    }

    @PostMapping("/houseuser")
    @ResponseBody
    public TableDataInfo list(Household household) {
        List<Household> list = householdService.selectAllHousehold(household);
        return getDataTable(list);
    }

    @PostMapping("/check")
    @ResponseBody
    public TableDataInfo list(TbTask tbTask){
        List<TbTask> list = taskService.selectTaskList(tbTask);
        for(int i=0;i<list.size();i++)
        {
            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null)
                    tbStaffs.add(staff);
            }
            list.get(i).setTbStaffList(tbStaffs);
        }
        return getDataTable(list);

    }
}
