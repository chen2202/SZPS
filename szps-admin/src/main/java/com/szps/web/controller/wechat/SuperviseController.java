package com.szps.web.controller.wechat;

import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysUser;
import com.szps.web.config.Picture;
import com.szps.web.domain.check.CheckPicture;
import com.szps.web.domain.supervise.*;
import com.szps.web.service.supervise.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.szps.common.utils.file.FileUploadUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.DecimalFormat;
import java.util.*;


@Controller
@RequestMapping("/admin/wechat")
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

    @Autowired
    private PictureService pictureService;

    @Autowired
    private Picture picture;


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
        List<TBALL> list1 = new ArrayList<>();
//        List<TbTask> list2 = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse = houseService.selectHouseById(a);
            TBALL tball = new TBALL();
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
                    List<TbPicture> pictures = pictureService.selectPictureById(tbTask1.getTaskNumber());
                    tball.setTbTask(tbTask1);
                    tball.setPictureList(getTbPictures(pictures));
                    list1.add(tball);

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
                    List<TbPicture> pictures = pictureService.selectPictureById(tbTask1.getTaskNumber());
                    tball.setTbTask(tbTask1);
                    tball.setPictureList(getTbPictures(pictures));
                    list1.add(tball);
                }
            }


        }


        return getDataTable(list1);

    }


    protected List<TbPicture> getTbPictures(List<TbPicture> tbPictures) {

        for (TbPicture tbPicture : tbPictures) {
            String url = tbPicture.getPictureLocation();
            url = picture.getUrl(url);
            tbPicture.setPictureLocation(url);
        }
        return tbPictures;
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

        System.out.println(list.size());
        List<TbTask> list2 = new ArrayList<>();


        SysUser sysUser = ShiroUtils.getSysUser();

        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse = houseService.selectHouseById(a);
            System.out.println(tbHouse.toString());
            TbTask tbTask1 = new TbTask();


            if (tbHouse.getHouseRule().equals(name)) {

                tbTask1 = list.get(i);

                List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
                List<TbStaff> tbStaffs = new ArrayList<TbStaff>();

                for (int k = 0; k < tbTaskStaffs.size(); k++) {
                    //System.out.println(tbTaskStaffs.get(k));
                    TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());


                       if(staff!=null){
                           if (sysUser.getUserName().equals(staff.getStaffName())) {


                               if (staff != null && Objects.equals(staff.getStaffPost(), "一类")) {
                                   tbStaffs.add(staff);
                               }
                               if (staff != null && Objects.equals(staff.getStaffPost(), "二类")) {
                                   tbStaffs.add(staff);
                               }

                               tbTask1.setTbStaffList(tbStaffs);
                               tbTask1.setTbHouse(tbHouse);
                               list2.add(tbTask1);
                           }
                       }
                }

            }

        }


        return getDataTable(list2);

    }


    /**
     * 排水监督检查文字上传
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/Supervise/add")
    @ResponseBody
    public int add(@RequestBody Map<String, Object> params) {

        String taskName = params.get("taskNumber").toString();

        TbTask tbTask2 = new TbTask();
        tbTask2.setTaskNumber(taskName);

        TbTask tbTask = Service.selectTaskById(tbTask2);

        System.out.println(tbTask.toString());

        if (tbTask.getTaskFlag().equals("未完成")) {

            TbTask tbTask1 = new TbTask();
            tbTask1.setTaskNumber(taskName);
            tbTask1.setTaskResult(params.get("result").toString());
            tbTask1.setTaskCheckTime(params.get("checkTime").toString());
            tbTask1.setTaskHandle(params.get("handle").toString());
            tbTask1.setTaskFlag("完成");

            return Service.updateTask(tbTask1);
        } else {
            return -1;
        }

    }

    /**
     * 排水监督检查图片上传
     *
     * @param multipartFile
     * @param feedbackId
     * @return
     */
    @PostMapping(value = "/uploadPicture")
    @ResponseBody
    public AjaxResult uploadPicture(@RequestParam("picture") MultipartFile[] multipartFile, @RequestParam(required = true) String feedbackId) {
        try {
            if (multipartFile.length == 0) {
                return error("文件为空,上传失败");
            }
            String filePath = Global.getUploadPath();
            String fileName[] = new String[10];
            String url[] = new String[10];
            for (int i = 0; i < multipartFile.length; i++) {
                fileName[i] = FileUploadUtils.upload(filePath, multipartFile[i]);
                url[i] = "/operation"+ fileName[i];
                int radomInt = new Random().nextInt(999999);
                String s = String.valueOf(radomInt);
                while (pictureService.checkPicture(s) == 1) {
                    s = String.valueOf(new Random().nextInt(999999));
                }
                TbPicture picture = new TbPicture();
                picture.setFeedbackId(feedbackId);
                picture.setPictureId(s);
                picture.setPictureLocation(url[i]);
                picture.setPictureName(multipartFile[i].getOriginalFilename());
                pictureService.insertRule(picture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }
}
