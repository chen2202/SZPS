package com.szps.web.controller.wechat;


import com.szps.web.domain.drainage.Household;
import com.szps.web.service.drainage.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/wechat")
public class DrainerController {
    @Autowired
    private HouseholdService householdService;


    @PostMapping(value = "/statistics/Areas")
    @ResponseBody
    public String[] getAreas(){
        String[] str={"光明区","前海开发区","南山区","坪山区","大鹏新区","宝安区","盐田区","福田区","罗湖区","龙华区","龙岗区"};

        return str;
    }

    /**
     * 各区排水户分布统计数据
     */
    @PostMapping("/statistics/householdAdministrativeStatistics")
    @ResponseBody
    public int[] householdAdministrativeStatistics() {
        List<String> administrativeList = householdService.selectAllHouseholdAdministrative(); //全部排水户所在行政区
        int gm=0,qhkf=0,ns=0,ps=0,dpx=0,ba=0,sshz=0,yt=0,ft=0,luoh=0,longh=0,lg=0,all=0; //各个行政区排水户计数
        for(int i=0;i<administrativeList.size();i++) {
            if(administrativeList.get(i).equals("光明区")) {
                gm++;
            }else if(administrativeList.get(i).equals("前海开发区")) {
                qhkf++;
            }else if(administrativeList.get(i).equals("南山区")) {
                ns++;
            }else if(administrativeList.get(i).equals("坪山区")) {
                ps++;
            }else if(administrativeList.get(i).equals("大鹏新区")) {
                dpx++;
            }else if(administrativeList.get(i).equals("宝安区")) {
                ba++;
            }else if(administrativeList.get(i).equals("盐田区")) {
                yt++;
            }else if(administrativeList.get(i).equals("福田区")) {
                ft++;
            }else if(administrativeList.get(i).equals("罗湖区")) {
                luoh++;
            }else if(administrativeList.get(i).equals("龙华区")) {
                longh++;
            }else if(administrativeList.get(i).equals("龙岗区")) {
                lg++;
            }
            all++;
        }
        int result[] = {gm,qhkf,ns,ps,dpx,ba,yt,ft,luoh,longh,lg,all};
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
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[0][6]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[0][7]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[0][8]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[0][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[0][10]++;
                }
                sewageArray[0][11]++;
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
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[1][6]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[1][7]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[1][8]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[1][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[1][10]++;
                }
                sewageArray[1][11]++;
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
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[2][6]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[2][7]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[2][8]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[2][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[2][10]++;
                }
                sewageArray[2][11]++;
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
                }else if(list.get(i).getAdministrative_name().equals("盐田区")) {
                    sewageArray[3][6]++;
                }else if(list.get(i).getAdministrative_name().equals("福田区")) {
                    sewageArray[3][7]++;
                }else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
                    sewageArray[3][8]++;
                }else if(list.get(i).getAdministrative_name().equals("龙华区")) {
                    sewageArray[3][9]++;
                }else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
                    sewageArray[3][10]++;
                }
                sewageArray[3][11]++;
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
     * 各区排水户记录状态统计
     */
    @PostMapping("/statistics/recordStateStatistics")
    @ResponseBody
    public List<Household> recordStateStatistics(Household household) {
        List<Household> list = householdService.selectAllHousehold(household);
        return list;
    }

    /**
     * 根据搜索统计排水户
     */
    @PostMapping("/statistics/recordStateStatistics1")
    @ResponseBody
    public List<Household> recordStateStatistics1(@RequestBody Map<String, Object> params ) {
        Household household =new Household();
        List<Household> list = householdService.selectAllHousehold(household);
        List<Household> list1=new ArrayList<>();
        String name = params.get("name").toString();
        for(Household household1:list){
             if(household1.getHousehold_name().contains(name)){
                 list1.add(household1);
             }
         }
        return list1;
    }

}
