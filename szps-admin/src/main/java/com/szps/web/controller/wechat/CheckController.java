package com.szps.web.controller.wechat;


import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysArea;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysAreaService;
import com.szps.system.service.ISysDeptService;
import com.szps.web.domain.check.Check;
import com.szps.web.domain.check.CheckPicture;
import com.szps.web.domain.check.PlantCheckRecord;
import com.szps.web.domain.event.EventPicture;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.domain.inspection.Area;
import com.szps.web.domain.inspection.type;
import com.szps.web.service.check.IPlantCheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.szps.common.core.domain.AjaxResult.error;
import static com.szps.common.core.domain.AjaxResult.success;

@Controller
@RequestMapping("/admin/check")
public class CheckController {


    @Autowired
    private IPlantCheckRecordService iPlantCheckRecordService;

    @Autowired
    private ISysAreaService iSysAreaService;

    @Autowired
    private ISysDeptService iSysDeptService;

    @Autowired
    private LoginController loginController;


    private String[] strings = {"水质净化厂", "泵站", "调蓄池", "分散式污水处理设施", "排水管网"};

    @PostMapping(value = "/lists")
    @ResponseBody
    public List<Check> getChecks(@RequestBody Map<String, Object> params) {

        String time = params.get("time").toString();
        String place = params.get("place").toString();

        List<PlantCheckRecord> list = getAlls(place);


        List<Check> checks = new ArrayList<>();


        if (time.equals("请选择日期")) {
            for (PlantCheckRecord plant : list) {


                CheckPicture checkPicture = new CheckPicture();
                checkPicture.setCheckSid(plant.getCheckId());
                List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                Check check = new Check();
                check.setPlantCheckRecord(plant);
                check.setList(checkPictures);

                //服务器路径路径
                check.setList(getPicture(checkPictures));

                checks.add(check);


            }
        } else {
            for (PlantCheckRecord plant : list) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String checkTime = sdf.format(plant.getCheckSubmitTime());

                if (checkTime.contains(time)) {

                    CheckPicture checkPicture = new CheckPicture();
                    checkPicture.setCheckSid(plant.getCheckId());
                    List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                    Check check = new Check();
                    check.setPlantCheckRecord(plant);
                    check.setList(checkPictures);

                    //服务器路径路径
                    check.setList(getPicture(checkPictures));

                    checks.add(check);
                }


            }
        }


        return checks;
    }

    /**
     * 搜索巡检列表
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/searchCheckLists")
    @ResponseBody
    public List<Check> getSearchCheckLists(@RequestBody Map<String, Object> params) {

        String time = params.get("time").toString();
        String value = params.get("value").toString();
        String place = params.get("place").toString();

        List<PlantCheckRecord> list = getAlls(place);


        List<Check> checks = new ArrayList<>();


        if (time.equals("请选择日期")) {
            for (PlantCheckRecord plant : list) {

                if (plant.getCheckPlace().contains(value)) {

                    CheckPicture checkPicture = new CheckPicture();
                    checkPicture.setCheckSid(plant.getCheckId());
                    List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                    Check check = new Check();
                    check.setPlantCheckRecord(plant);
                    check.setList(checkPictures);
                    //服务器路径路径
                    check.setList(getPicture(checkPictures));

                    checks.add(check);

                }
            }
        } else {
            for (PlantCheckRecord plant : list) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String checkTime = sdf.format(plant.getCheckSubmitTime());

                if (checkTime.contains(time) && plant.getCheckPlace().contains(value)) {

                    CheckPicture checkPicture = new CheckPicture();
                    checkPicture.setCheckSid(plant.getCheckId());
                    List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                    Check check = new Check();
                    check.setPlantCheckRecord(plant);
                    check.setList(checkPictures);
                    //服务器路径路径
                    check.setList(getPicture(checkPictures));

                    checks.add(check);
                }


            }
        }


        return checks;
    }

    /**
     * 图片路径转为服务器图片路径
     *
     * @param checkPictures
     * @return
     */
    protected List<CheckPicture> getPicture(List<CheckPicture> checkPictures) {

        for (CheckPicture checkPicture : checkPictures) {
            String url = checkPicture.getGetCheckPictureUrl();
            url = "https://vx.newground.cn:7000" + url;
            checkPicture.setGetCheckPictureUrl(url);
        }
        return checkPictures;
    }

    /**
     * 不同的角色获取不同的列表
     *
     * @return
     */
    protected List<PlantCheckRecord> getAlls(String name) {
        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();

        List<PlantCheckRecord> list = new ArrayList<>();
        if (loginController.getSysRole().equals("市水务局人员")) {
            if (!name.equals("请选择")) {
                plantCheckRecord.setCheckPlace(name);
            }
            list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);
        } else if (loginController.getSysRole().equals("区水务局人员")) {
            if (!name.equals("请选择")) {
                plantCheckRecord.setCheckPlace(name);
            }
            plantCheckRecord.setCheckArea(loginController.getSysDept());
            list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);
        } else {
            SysUser sysUser = ShiroUtils.getSysUser();
            SysDept sysDept = iSysDeptService.selectDeptById(sysUser.getDeptId());
            plantCheckRecord.setCheckDept(sysDept.getDeptName());

            list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);
        }
        return list;
    }


    /**
     * 获取巡检管理下拉框信息
     *
     * @return
     */
    @PostMapping(value = "getTypes")
    @ResponseBody
    public Object getAreaTypes() {

        SysArea sysArea = new SysArea();
        List<SysArea> areas = iSysAreaService.selectAreaList(sysArea);


        List<type> s = new ArrayList<>();

        if (loginController.getSysRole().equals("市水务局人员")) {
            String[][] strings = new String[55][];

            List<type> types = new ArrayList<>();
            for (SysArea sysArea1 : areas) {
                Area area = new Area();
                area.setArea(sysArea1.getAreaName());

                types = getSysDepts(sysArea1.getAreaName(), s);

            }

            int i = 0;
            strings = getStrings(types, strings, i++);
            return strings;
        } else {

            List<type> types = getSysDepts(loginController.getSysDept(), s);
            String[][] strings = new String[5][];


            return getStrings(types, strings, 0);
        }

    }


    /**
     * 获取不同类型的巡检地点
     *
     * @param name
     * @return
     */
    protected List<type> getSysDepts(String name, List<type> types) {

        List<SysDept> sysDepts = new ArrayList<>();

        if (name.equals("深圳市")) {
            sysDepts = iSysDeptService.getSysDepts2();
        } else {
            sysDepts = iSysDeptService.getSysDepts(name);

        }


        for (int i = 0; i < strings.length; i++) {


            type s = new type();
            List<SysDept> sysDepts1 = new ArrayList<>();
            s.setTypeName(strings[i]);

            for (SysDept sysDept : sysDepts) {

                if (sysDept.getDeptName().contains(strings[i])) {

                    sysDepts1.add(sysDept);

                }
            }
            s.setSysDepts(sysDepts1);
            types.add(s);
        }


        return types;
    }

    /**
     * 巡检管理文字上传接口
     *
     * @param checkPlace
     * @param checkDetail
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/checkUpload")
    @ResponseBody

    public String upload(@RequestParam("checkPlace") String checkPlace,
                         @RequestParam("checkDetail") String checkDetail) throws ParseException {


        int radomInt = new Random().nextInt(999999);

        while (checkCheckSid(String.valueOf(radomInt)) == 1) {
            radomInt = new Random().nextInt(999999);
        }
        String s = String.valueOf(radomInt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String ss = sdf.format(date);

        Date date1 = sdf.parse(ss);

        SysUser user = ShiroUtils.getSysUser();
        SysDept sysDept = iSysDeptService.selectDeptById(user.getDeptId());

        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        plantCheckRecord.setCheckId(s);
        plantCheckRecord.setCheckArea(loginController.getSysDept());
        plantCheckRecord.setCheckPlace(checkPlace);
        plantCheckRecord.setCheckSubmitTime(date1);
        plantCheckRecord.setCheckUser(user.getUserName());
        plantCheckRecord.setCheckDetail(checkDetail);
        plantCheckRecord.setCheckDept(sysDept.getDeptName());
        plantCheckRecord.setCheckPhone(user.getPhonenumber());

        for (int i = 0; i < strings.length; i++) {
            if (checkPlace.contains(strings[i])) {
                plantCheckRecord.setCheckType(strings[i]);
            }
        }

        iPlantCheckRecordService.insertCheckManager(plantCheckRecord);

        return s;
    }


    /**
     * 上传巡检管理图片
     *
     * @param multipartFile
     * @param feedbackId
     * @return
     */
    @PostMapping(value = "/checkPictureUpload")
    @ResponseBody
    public AjaxResult uploadPicture(@RequestParam("picture") MultipartFile[] multipartFile, @RequestParam(required = true)
            String feedbackId) {
        try {
            if (multipartFile.length == 0) {
                return error("文件为空,上传失败");
            }
            String filePath = Global.getUploadPath();
            String fileName[] = new String[10];
            String url[] = new String[10];
            for (int i = 0; i < multipartFile.length; i++) {

                fileName[i] = FileUploadUtils.upload(filePath, multipartFile[i]);
                url[i] = fileName[i];

                CheckPicture picture = new CheckPicture();
                picture.setCheckSid(feedbackId);
                picture.setCheckPictureName(multipartFile[i].getOriginalFilename());
                picture.setGetCheckPictureUrl(url[i]);

                iPlantCheckRecordService.insertPicture(picture);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }


    /**
     * 获取下拉框行政区
     *
     * @return
     */
    @PostMapping(value = "checkArea")
    @ResponseBody
    public String[] getCheckArea() {
        SysArea sysArea = new SysArea();

        List<SysArea> sysAreas = iSysAreaService.selectAreaList(sysArea);
        String[] str = new String[sysAreas.size()];
        int i = 0;
        for (SysArea sysArea1 : sysAreas) {
            str[i++] = sysArea1.getAreaName();
        }
        return str;
    }


    /**
     * 获取下拉框类型
     *
     * @return
     */
    @PostMapping(value = "checkTypes")
    @ResponseBody
    public String[] getCheckTypes() {

        return strings;
    }

    /**
     * 检查CheckSid是否重复
     *
     * @return
     */
    protected int checkCheckSid(String sid) {

        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        plantCheckRecord.setCheckId(sid);

        List<PlantCheckRecord> plantCheckRecords = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);

        if (plantCheckRecords.size() == 1) {
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * 分类水质厂等类型
     *
     * @param types
     * @param strings
     * @param x
     * @return
     */
    protected String[][] getStrings(List<type> types, String[][] strings, int x) {

        for (int i = 0; i < types.size(); i++) {

            List<SysDept> sysDepts = types.get(i).getSysDepts();

            strings[x * 5 + i] = new String[sysDepts.size()];

            for (int j = 0; j < sysDepts.size(); j++) {
                strings[i][j] = sysDepts.get(j).getDeptName();
            }
        }
        return strings;
    }
}
