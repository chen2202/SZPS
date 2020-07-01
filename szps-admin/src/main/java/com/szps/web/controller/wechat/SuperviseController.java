package com.szps.web.controller.wechat;

import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.domain.supervise.TbTaskStaff;
import com.szps.web.service.supervise.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Controller
@RequestMapping("/wechat")
public class SuperviseController extends BaseController {


    @Autowired
    private TaskService Service;

    @Autowired
    private TaskStaffService taskStaffService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private HouseService houseService;
    @Autowired
    private RuleService ruleService;

    /**
     * 初始化数据拉取
     *
     * @param params
     * @return
     */
    @PostMapping("/Supervise/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody Map<String, Object> params) {

        String name = params.get("name").toString();
        String Time = params.get("time").toString();


        TbTask tbTask = new TbTask();


        tbTask.setTaskFlag("完成");

        List<TbTask> list = Service.selectTaskList(tbTask);

        List<TbTask> list2 = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse = houseService.selectHouseById(a);
            TbTask tbTask1 = new TbTask();


            if (!Time.equals("请选择日期")) {

                if (tbHouse.getHouseRule().equals(name) && list.get(i).getTaskTime().contains(Time)) {

                    tbTask1 = list.get(i);

                    List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                    List<TbStaff> tbStaffs = new ArrayList<TbStaff>();
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "一类"))
                            tbStaffs.add(staff);
                    }
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "二类"))
                            tbStaffs.add(staff);
                    }
                    tbTask1.setTbStaffList(tbStaffs);
                    tbTask1.setTbHouse(tbHouse);
                    list2.add(tbTask1);
                }
            } else {
                if (tbHouse.getHouseRule().equals(name)) {

                    tbTask1 = list.get(i);

                    List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                    List<TbStaff> tbStaffs = new ArrayList<TbStaff>();
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "一类"))
                            tbStaffs.add(staff);
                    }
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "二类"))
                            tbStaffs.add(staff);
                    }
                    tbTask1.setTbStaffList(tbStaffs);
                    tbTask1.setTbHouse(tbHouse);
                    list2.add(tbTask1);
                }
            }


        }


        return getDataTable(list2);

    }

    /**
     * 初始化数据统计
     *
     * @param params
     * @return
     */
    @PostMapping("/getRate")
    @ResponseBody
    public String getRate(@RequestBody Map<String, Object> params) {

        String name = params.get("name").toString();
        String Time = params.get("time").toString();

        int all = houseService.selectHouseCount();
        TbTask tbTask = new TbTask();

        tbTask = new TbTask();
        tbTask.setTaskFlag("完成");

        List<TbTask> list = Service.selectTaskList(tbTask);
        List<TbTask> list2 = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse = houseService.selectHouseById(a);
            TbTask tbTask1 = new TbTask();


            if (!Time.equals("请选择日期")) {

                if (tbHouse.getHouseRule().equals(name) && list.get(i).getTaskTime().contains(Time)) {

                    tbTask1 = list.get(i);

                    List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                    List<TbStaff> tbStaffs = new ArrayList<TbStaff>();
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "一类"))
                            tbStaffs.add(staff);
                    }
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "二类"))
                            tbStaffs.add(staff);
                    }
                    tbTask1.setTbStaffList(tbStaffs);
                    tbTask1.setTbHouse(tbHouse);
                    list2.add(tbTask1);
                }
            } else {
                if (tbHouse.getHouseRule().equals(name)) {

                    tbTask1 = list.get(i);

                    List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                    List<TbStaff> tbStaffs = new ArrayList<TbStaff>();
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "一类"))
                            tbStaffs.add(staff);
                    }
                    for (int k = 0; k < tbTaskStaffs.size(); k++) {
                        //System.out.println(tbTaskStaffs.get(k));
                        TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                        if (staff != null && Objects.equals(staff.getStaffPost(), "二类"))
                            tbStaffs.add(staff);
                    }
                    tbTask1.setTbStaffList(tbStaffs);
                    tbTask1.setTbHouse(tbHouse);
                    list2.add(tbTask1);
                }
            }


        }

        int count = list2.size();

        String rate;
        if (count != 0) {

            float kk = (float) count / all;

            DecimalFormat df = new DecimalFormat("#.00");
            rate = df.format(kk * 100) + "%";
        } else {
            rate = "0.00 %";
        }
        return rate;
    }

    /**
     * 排水监督任务列表
     *
     * @param params
     * @return
     */

    @PostMapping("/Supervise/Tasklist")
    @ResponseBody
    public TableDataInfo Tasklist(@RequestBody Map<String, Object> params) {

        String name = params.get("name").toString();

        TbTask tbTask = new TbTask();


        tbTask.setTaskFlag("未完成");

        List<TbTask> list = Service.selectTaskList(tbTask);

        List<TbTask> list2 = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse = houseService.selectHouseById(a);
            TbTask tbTask1 = new TbTask();


            if (tbHouse.getHouseRule().equals(name)) {

                tbTask1 = list.get(i);

                List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                List<TbStaff> tbStaffs = new ArrayList<TbStaff>();
                for (int k = 0; k < tbTaskStaffs.size(); k++) {
                    //System.out.println(tbTaskStaffs.get(k));
                    TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                    if (staff != null && Objects.equals(staff.getStaffPost(), "一类"))
                        tbStaffs.add(staff);
                }
                for (int k = 0; k < tbTaskStaffs.size(); k++) {
                    //System.out.println(tbTaskStaffs.get(k));
                    TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                    if (staff != null && Objects.equals(staff.getStaffPost(), "二类"))
                        tbStaffs.add(staff);
                }
                tbTask1.setTbStaffList(tbStaffs);
                tbTask1.setTbHouse(tbHouse);
                list2.add(tbTask1);
            }


        }


        return getDataTable(list2);

    }


    @PostMapping(value = "/Supervise/add")
    @ResponseBody
    public int add(@RequestBody Map<String, Object> params) {

        String taskName = params.get("taskNumber").toString();

        TbTask tbTask=Service.selectTaskById(taskName);
        if(tbTask.getTaskFlag().equals("未完成")){

            TbTask tbTask1=new TbTask();
            tbTask1.setTaskNumber(taskName);
            tbTask1.setTaskResult(params.get("result").toString());
            tbTask1.setTaskCheckTime(params.get("checkTime").toString());
            tbTask1.setTaskHandle(params.get("handle").toString());

            return Service.updateTask(tbTask1);
        }else {
            return -1;
        }

    }

}
