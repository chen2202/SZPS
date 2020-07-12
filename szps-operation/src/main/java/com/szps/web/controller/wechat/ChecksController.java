package com.szps.web.controller.wechat;


import com.szps.web.domain.check.Checks;
import com.szps.web.domain.check.CheckPicture;
import com.szps.web.domain.check.PlantCheckRecord;
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
public class ChecksController {


    @Autowired
    private IPlantCheckRecordService iPlantCheckRecordService;

    @PostMapping(value = "/lists")
    @ResponseBody
    public List<Checks> getChecks(@RequestBody Map<String, Object> params) {

        String time = params.get("time").toString();
        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        List<PlantCheckRecord> list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);


        List<Checks> checks = new ArrayList<>();


        if (time.equals("请选择日期")) {
            for (PlantCheckRecord plant : list) {

                CheckPicture checkPicture = new CheckPicture();
                checkPicture.setCheckSid(plant.getCheckId());
                List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                Checks check = new Checks();
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

                    Checks check = new Checks();
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
    public List<Checks> getSearchCheckLists(@RequestBody Map<String, Object> params) {

        String time = params.get("time").toString();
        String value = params.get("value").toString();

        PlantCheckRecord plantCheckRecord = new PlantCheckRecord();
        List<PlantCheckRecord> list = iPlantCheckRecordService.selectCheckManagerList(plantCheckRecord);


        List<Checks> checks = new ArrayList<>();


        if (time.equals("请选择日期")) {
            for (PlantCheckRecord plant : list) {

                if (plant.getCheckPlace().contains(value)) {


                    CheckPicture checkPicture = new CheckPicture();
                    checkPicture.setCheckSid(plant.getCheckId());
                    List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                    Checks check = new Checks();
                    check.setPlantCheckRecord(plant);
                    check.setList(checkPictures);

                    checks.add(check);

                }
            }
        } else {
            for (PlantCheckRecord plant : list) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String checkTime = sdf.format(plant.getCheckSubmitTime());

                if (checkTime.contains(time)&&plant.getCheckPlace().contains(value)) {

                    CheckPicture checkPicture = new CheckPicture();
                    checkPicture.setCheckSid(plant.getCheckId());
                    List<CheckPicture> checkPictures = iPlantCheckRecordService.getCheckPictures(checkPicture);

                    Checks check = new Checks();
                    check.setPlantCheckRecord(plant);
                    check.setList(checkPictures);

                    checks.add(check);
                }


            }
        }


        return checks;
    }
}
