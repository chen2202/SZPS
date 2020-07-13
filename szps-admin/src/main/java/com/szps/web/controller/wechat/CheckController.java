package com.szps.web.controller.wechat;


import com.szps.common.annotation.Log;
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
import com.szps.web.domain.inspection.Area;
import com.szps.web.domain.inspection.type;
import com.szps.web.service.check.IPlantCheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    private String[] strings = {"水质净化厂", "泵站", "调蓄池", "分散式污水处理设施"};

    @PostMapping(value = "/lists")
    @ResponseBody
    public List<Check> getChecks(@RequestBody Map<String, Object> params) {

        String time = params.get("time").toString();
        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        List<PlantCheckRecord> list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);


        List<Check> checks = new ArrayList<>();


        if (time.equals("请选择日期")) {
            for (PlantCheckRecord plant : list) {

                CheckPicture checkPicture = new CheckPicture();
                checkPicture.setCheckSid(plant.getCheckId());
                List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                Check check = new Check();
                check.setPlantCheckRecord(plant);
                check.setList(checkPictures);

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

        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        List<PlantCheckRecord> list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);


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

                    checks.add(check);
                }


            }
        }


        return checks;
    }


    /**
     * 获取
     *
     * @return
     */
    @PostMapping(value = "getTypes")
    @ResponseBody
    public List<Area> getAreaTypes(SysArea sysArea) {

        List<SysArea> areas = iSysAreaService.selectAreaList(sysArea);

        List<Area> areas1 = new ArrayList<>();

        for (SysArea sysArea1 : areas) {
            Area area = new Area();
            area.setArea(sysArea1.getAreaName());

            List<type> types = new ArrayList<>();

            for (int i = 0; i < strings.length; i++) {
                type type = new type();
                type.setTypeName(strings[i]);

                type.setSysDepts(null);

            }


        }
        return null;


    }

    @PostMapping(value = "11111")
    @ResponseBody
    public List<SysDept> getSysDepts(String name) {

        name="龙华区";
        List<SysDept> sysDepts = iSysDeptService.getSysDepts(name);

        return sysDepts;
    }


}
