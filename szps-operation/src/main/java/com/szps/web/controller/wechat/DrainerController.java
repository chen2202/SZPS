package com.szps.web.controller.wechat;


import com.szps.web.domain.drainage.Household;
import com.szps.web.service.drainage.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrainerController {
    @Autowired
    private HouseholdService householdService;


    @PostMapping("/statistics/drainageLicenseExpire")
    @ResponseBody
    public int[] DrainageLicenseExpire() {
        List<String> DrainageLicenseList = householdService.selectDrainageLicenseExpire();
        int gm=0,qhkf=0,ns=0,ps=0,dpx=0,ba=0,sshz=0,yt=0,ft=0,luoh=0,longh=0,lg=0; //各个行政区排水户计数
        for(int i=0;i<DrainageLicenseList.size();i++) {
            if(DrainageLicenseList.get(i).equals("光明区")) {
                gm++;
            }else if(DrainageLicenseList.get(i).equals("前海开发区")) {
                qhkf++;
            }else if(DrainageLicenseList.get(i).equals("南山区")) {
                ns++;
            }else if(DrainageLicenseList.get(i).equals("坪山区")) {
                ps++;
            }else if(DrainageLicenseList.get(i).equals("大鹏新区")) {
                dpx++;
            }else if(DrainageLicenseList.get(i).equals("宝安区")) {
                ba++;
            }else if(DrainageLicenseList.get(i).equals("深汕合作区")) {
                sshz++;
            }else if(DrainageLicenseList.get(i).equals("盐田区")) {
                yt++;
            }else if(DrainageLicenseList.get(i).equals("福田区")) {
                ft++;
            }else if(DrainageLicenseList.get(i).equals("罗湖区")) {
                luoh++;
            }else if(DrainageLicenseList.get(i).equals("龙华区")) {
                longh++;
            }else if(DrainageLicenseList.get(i).equals("龙岗区")) {
                lg++;
            }
        }
        int result[] = {gm,qhkf,ns,ps,dpx,ba,sshz,yt,ft,luoh,longh,lg};
        return result;
    }

    /**
     * 各行政区污水类别统计
     */
    @PostMapping("/statistics/adminiSewageStatistics")
    @ResponseBody
    public String adminiSewageStatistics() {
        List<Household> list = householdService.selectAllAdminiSewage(); //获取各行政区以及污水类别
        int sewageArray[][] = new int[][] {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}}; //放置四种污水类别数组
        for(int i=0;i<list.size();i++) { //赋值数据
            //System.out.println(list.get(i).getAdministrative_name()+"------"+list.get(i).getSewage_category());
            if(list.get(i).getSewage_category().equals("有毒有害排污类")) {
                if(list.get(i).getAdministrative_name().equals("光明区")) {
                    sewageArray[0][0]++;
                }else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
                    sewageArray[0][1]++;
                }else if(list.get(i).getAdministrative_name().equals("南山区")) {
                    sewageArray[0][2]++;
                }else if(list.get(i).getAdministrative_name().equals("坪山区")) {
                    sewageArray[0][3]++;
                }else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
                    sewageArray[0][4]++;
                }else if(list.get(i).getAdministrative_name().equals("宝安区")) {
                    sewageArray[0][5]++;
                }else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
                    sewageArray[0][6]++;
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[0][7]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[0][8]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[0][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[0][10]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[0][11]++;
                }
            }else if(list.get(i).getSewage_category().equals("沉淀物排污类")) {
                if(list.get(i).getAdministrative_name().equals("光明区")) {
                    sewageArray[1][0]++;
                }else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
                    sewageArray[1][1]++;
                }else if(list.get(i).getAdministrative_name().equals("南山区")) {
                    sewageArray[1][2]++;
                }else if(list.get(i).getAdministrative_name().equals("坪山区")) {
                    sewageArray[1][3]++;
                }else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
                    sewageArray[1][4]++;
                }else if(list.get(i).getAdministrative_name().equals("宝安区")) {
                    sewageArray[1][5]++;
                }else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
                    sewageArray[1][6]++;
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[1][7]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[1][8]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[1][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[1][10]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[1][11]++;
                }
            }else if(list.get(i).getSewage_category().equals("餐饮排污类")) {
                if(list.get(i).getAdministrative_name().equals("光明区")) {
                    sewageArray[2][0]++;
                }else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
                    sewageArray[2][1]++;
                }else if(list.get(i).getAdministrative_name().equals("南山区")) {
                    sewageArray[2][2]++;
                }else if(list.get(i).getAdministrative_name().equals("坪山区")) {
                    sewageArray[2][3]++;
                }else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
                    sewageArray[2][4]++;
                }else if(list.get(i).getAdministrative_name().equals("宝安区")) {
                    sewageArray[2][5]++;
                }else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
                    sewageArray[2][6]++;
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[2][7]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[2][8]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[2][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[2][10]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[2][11]++;
                }
            }else if(list.get(i).getSewage_category().equals("生活排污类")) {
                if(list.get(i).getAdministrative_name().equals("光明区")) {
                    sewageArray[3][0]++;
                }else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
                    sewageArray[3][1]++;
                }else if(list.get(i).getAdministrative_name().equals("南山区")) {
                    sewageArray[3][2]++;
                }else if(list.get(i).getAdministrative_name().equals("坪山区")) {
                    sewageArray[3][3]++;
                }else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
                    sewageArray[3][4]++;
                }else if(list.get(i).getAdministrative_name().equals("宝安区")) {
                    sewageArray[3][5]++;
                }else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
                    sewageArray[3][6]++;
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[3][7]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[3][8]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[3][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[3][10]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[3][11]++;
                }
            }
        }
        //准备需要传递的json数据
        String json = "[";
        for(int i=0;i<4;i++) {
            json += "[";
            for(int j=0;j<12;j++) {
                json += sewageArray[i][j]+"";
                if(j!=11) {
                    json += ",";
                }
            }
            json += "]";
            if(i!=3) {
                json += ",";
            }
        }
        json += "]";
        //System.out.println(json);

        return json;
    }

    /**
     * 全市污水类别比例统计
     */
    @PostMapping("/statistics/sewageCategoryStatistics")
    @ResponseBody
    public String sewageCategoryStatistics() {
        List<String> list = householdService.selectAllSewageCategory();
        int ydyh=0,cdw=0,cy=0,sh=0;
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals("有毒有害排污类")) {
                ydyh++;
            }else if(list.get(i).equals("沉淀物排污类")) {
                cdw++;
            }else if(list.get(i).equals("餐饮排污类")) {
                cy++;
            }else if(list.get(i).equals("生活排污类")) {
                sh++;
            }
        }

        return "["
                + "{\"y\":"+ydyh+",\"name\":\"有毒有害排污类\"},"
                + "{\"y\":"+cdw+",\"name\":\"沉淀物排污类\"},"
                + "{\"y\":"+cy+",\"name\":\"餐饮排污类\"},"
                + "{\"y\":"+sh+",\"name\":\"生活排污类\"}"
                + "]";
    }
}
