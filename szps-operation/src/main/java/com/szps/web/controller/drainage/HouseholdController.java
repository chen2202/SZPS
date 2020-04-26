package com.szps.web.controller.drainage;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.drainage.Household;
import com.szps.web.service.drainage.HouseholdService;

/**
 * 排水户管理 控制器
 * @author zxc
 *
 */
@Controller
@RequestMapping("/drainage")
public class HouseholdController extends BaseController{
	private String prefix = "drainage/household"; 
	
	@Autowired
	private HouseholdService householdService;
	
	/**
	 * 跳转到household.html
	 * 
	 */
	@RequiresPermissions("drainage:household:view")
    @GetMapping("/household")
    public String household(){
        return prefix + "/household";
    }
    
    /**
	 * 添加 排水户 信息到household.html
	 * 
	 */
	@RequiresPermissions("drainage:household:list")
    @PostMapping("/household/list")
    @ResponseBody
    public TableDataInfo list(Household household) {
		startPage();
		List<Household> list = householdService.selectAllHousehold(household);
		return getDataTable(list);
	}
	
	//@Log(title = "排水户管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("drainage:household:export")
    @PostMapping("/household/export")
    @ResponseBody
    public AjaxResult export(Household household)
    {
        List<Household> list = householdService.selectAllHousehold(household);
        ExcelUtil<Household> util = new ExcelUtil<Household>(Household.class);
        return util.exportExcel(list, "排水户数据");
    }
    
	/**
     * 新增排水户
     * 跳转到add.html
     */
    @GetMapping("/household/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 保存新增排水户
     */
    @RequiresPermissions("drainage:household:add")
    @Log(title = "排水户增加", businessType = BusinessType.INSERT)
    @PostMapping("/household/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Household household){   
	    householdService.insertHousehold(household);
        return toAjax(1); 
    }
    
    /**
     * 修改排水户
     * 跳转到edit.html
     */
    @GetMapping("/household/edit/{household_id}")
    public String edit(@PathVariable("household_id") int household_id,ModelMap mmap) {
    	mmap.put("household", householdService.selectHouseholdById(household_id));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存排水户
     * 
     */
    @RequiresPermissions("drainage:household:edit")
    @Log(title = "排水户修改", businessType = BusinessType.UPDATE)
    @PostMapping("/household/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Household household) {
    	householdService.updateHousehold(household);
    	return toAjax(1);
    }
    
    /**
     * 根据排水户编号删除排水户以及排水户下排水口
     */
    @RequiresPermissions("drainage:household:remove")
    @Log(title = "排水户删除", businessType = BusinessType.DELETE)
    @PostMapping("/household/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		int deleterows = householdService.deleteDrainById(ids) + householdService.deleteHouseholdById(ids);
    		return toAjax(deleterows);
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验排水户ID唯一性
     */
    @PostMapping("/household/checkHouseholdIdUnique")
    @ResponseBody
    public String checkHouseholdIdUnique(Household household){
        return householdService.checkHouseholdIdUnique(household); 
    }
    
    
    //------------------------------以下是四个总数统计数据部分
    public Model count(Model m) {
    	int count1 = householdService.selectHouseholdCount(); //全市摸查排水户总数
    	m.addAttribute("householdCount", count1);
    	int count2 = householdService.selectHouseholdRecordStateCount();
    	m.addAttribute("recordState", count2);
    	int count3 = householdService.pwzdqCount();
    	m.addAttribute("pwzdq", count3);
    	int count4 = householdService.pszdqCount();
    	m.addAttribute("pszdq", count4);
    	return m;
    }
    
    //------------------------------以下是统计数据部分--------------------------------------
    /**
	 * 跳转到drainage/statistics/statistics.html 统计数据页面
	 */
	//@RequiresPermissions("drainage:household:view")
    @GetMapping("/statistics")
    public String statistics(Model model){	
    	count(model); //传递四个数据
        return "drainage/statistics" + "/statistics";
    }
    
    /**
     * 各区排水户分布统计数据
     */
    @PostMapping("/statistics/householdAdministrativeStatistics")
	@ResponseBody
	public int[] householdAdministrativeStatistics() {
    	List<String> administrativeList = householdService.selectAllHouseholdAdministrative(); //全部排水户所在行政区
    	int gm=0,qhkf=0,ns=0,ps=0,dpx=0,ba=0,sshz=0,yt=0,ft=0,luoh=0,longh=0,lg=0; //各个行政区排水户计数
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
    		}else if(administrativeList.get(i).equals("深汕合作区")) {
    			sshz++;
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
    	}
    	int result[] = {gm,qhkf,ns,ps,dpx,ba,sshz,yt,ft,luoh,longh,lg};
    	return result;
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
     * 各区排水户记录状态统计
     */
    @PostMapping("/statistics/recordStateStatistics")
   	@ResponseBody
   	public String recordStateStatistics() {
    	List<Household> list = householdService.selectAllAdminiRecord();
    	int recordArray[][] = new int[][] {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
    		{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}}; //放置四种记录状态的数组
    	for(int i=0;i<list.size();i++) { //赋值数据
    		if(list.get(i).getRecord_state().equals("已审核")) {
    			if(list.get(i).getAdministrative_name().equals("光明区")) {
    				recordArray[0][0]++;
        		}else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
        			recordArray[0][1]++;
        		}else if(list.get(i).getAdministrative_name().equals("南山区")) {
        			recordArray[0][2]++;
        		}else if(list.get(i).getAdministrative_name().equals("坪山区")) {
        			recordArray[0][3]++;
        		}else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
        			recordArray[0][4]++;
        		}else if(list.get(i).getAdministrative_name().equals("宝安区")) {
        			recordArray[0][5]++;
        		}else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
        			recordArray[0][6]++;
        		}else if(list.get(i).getAdministrative_name().equals("盐田区")) {
        			recordArray[0][7]++;
        		}else if(list.get(i).getAdministrative_name().equals("福田区")) {
        			recordArray[0][8]++;
        		}else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
        			recordArray[0][9]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙华区")) {
        			recordArray[0][10]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
        			recordArray[0][11]++;
        		}
    		}else if(list.get(i).getRecord_state().equals("待修改")) {
    			if(list.get(i).getAdministrative_name().equals("光明区")) {
    				recordArray[1][0]++;
        		}else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
        			recordArray[1][1]++;
        		}else if(list.get(i).getAdministrative_name().equals("南山区")) {
        			recordArray[1][2]++;
        		}else if(list.get(i).getAdministrative_name().equals("坪山区")) {
        			recordArray[1][3]++;
        		}else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
        			recordArray[1][4]++;
        		}else if(list.get(i).getAdministrative_name().equals("宝安区")) {
        			recordArray[1][5]++;
        		}else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
        			recordArray[1][6]++;
        		}else if(list.get(i).getAdministrative_name().equals("盐田区")) {
        			recordArray[1][7]++;
        		}else if(list.get(i).getAdministrative_name().equals("福田区")) {
        			recordArray[1][8]++;
        		}else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
        			recordArray[1][9]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙华区")) {
        			recordArray[1][10]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
        			recordArray[1][11]++;
        		}
    		}else if(list.get(i).getRecord_state().equals("待审核")) {
    			if(list.get(i).getAdministrative_name().equals("光明区")) {
    				recordArray[2][0]++;
        		}else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
        			recordArray[2][1]++;
        		}else if(list.get(i).getAdministrative_name().equals("南山区")) {
        			recordArray[2][2]++;
        		}else if(list.get(i).getAdministrative_name().equals("坪山区")) {
        			recordArray[2][3]++;
        		}else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
        			recordArray[2][4]++;
        		}else if(list.get(i).getAdministrative_name().equals("宝安区")) {
        			recordArray[2][5]++;
        		}else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
        			recordArray[2][6]++;
        		}else if(list.get(i).getAdministrative_name().equals("盐田区")) {
        			recordArray[2][7]++;
        		}else if(list.get(i).getAdministrative_name().equals("福田区")) {
        			recordArray[2][8]++;
        		}else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
        			recordArray[2][9]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙华区")) {
        			recordArray[2][10]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
        			recordArray[2][11]++;
        		}
    		}else if(list.get(i).getRecord_state().equals("待提交")) {
    			if(list.get(i).getAdministrative_name().equals("光明区")) {
    				recordArray[3][0]++;
        		}else if(list.get(i).getAdministrative_name().equals("前海开发区")) {
        			recordArray[3][1]++;
        		}else if(list.get(i).getAdministrative_name().equals("南山区")) {
        			recordArray[3][2]++;
        		}else if(list.get(i).getAdministrative_name().equals("坪山区")) {
        			recordArray[3][3]++;
        		}else if(list.get(i).getAdministrative_name().equals("大鹏新区")) {
        			recordArray[3][4]++;
        		}else if(list.get(i).getAdministrative_name().equals("宝安区")) {
        			recordArray[3][5]++;
        		}else if(list.get(i).getAdministrative_name().equals("深汕合作区")) {
        			recordArray[3][6]++;
        		}else if(list.get(i).getAdministrative_name().equals("盐田区")) {
        			recordArray[3][7]++;
        		}else if(list.get(i).getAdministrative_name().equals("福田区")) {
        			recordArray[3][8]++;
        		}else if(list.get(i).getAdministrative_name().equals("罗湖区")) {
        			recordArray[3][9]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙华区")) {
        			recordArray[3][10]++;
        		}else if(list.get(i).getAdministrative_name().equals("龙岗区")) {
        			recordArray[3][11]++;
        		}
    		}
    	}
    	//准备需要传递的json数据
    	String json = "[";
    	for(int i=0;i<4;i++) {
    		json += "[";
    		for(int j=0;j<12;j++) {
    			json += recordArray[i][j]+"";
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
    	
    	return json;
    }
}
