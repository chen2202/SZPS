package com.szps.web.controller.report;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.report.Pump;
import com.szps.web.domain.report.PumpDetail;
import com.szps.web.service.report.IPumpDetailService;
import com.szps.web.service.report.IPumpService;

@Controller
@RequestMapping("/op/report/pump")
public class PumpController extends BaseController {
	@Autowired
	private IPumpService service;
	@Autowired
	private IPumpDetailService detailService;
	
	private String prefix = "/report/pump";
	
    @RequiresPermissions("report:pump:view")
    @GetMapping()
    public String pump()
    {
        return prefix + "/view";
    }
    
    @RequiresPermissions("report:pump:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pump pump)
    {
        startPage();
        List<Pump> list = service.selectReportList(pump);
        return getDataTable(list);
    }
    

    
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("report:pump:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Pump pump, @RequestParam("assetname")String[] assetnames
    		, @RequestParam("supplyer")String[] supplyers
    		, @RequestParam("dspec")String[] dspecs
    		, @RequestParam("dunit")String[] dunits
    		, @RequestParam("areaorquantity")String[] areaorquantitys
    		, @RequestParam("remark")String[] remarks
    		, @RequestParam("assetname2")String[] assetname2s
    		, @RequestParam("supplyer2")String[] supplyer2s
    		, @RequestParam("dspec2")String[] dspec2s
    		, @RequestParam("dunit2")String[] dunit2s
    		, @RequestParam("areaorquantity2")String[] areaorquantity2s
    		, @RequestParam("remark2")String[] remark2s)
    {
		
		 SysUser user = ShiroUtils.getSysUser();
		 pump.setCreateBy(user.getLoginName());
		 
        try {
        	
        	service.insertReport(pump);
        	Long pumpid = pump.getId();
        	int size = assetnames.length;
        	int k = 0 ;
        	for(int i =0;i<size;i++){
        		PumpDetail p = new PumpDetail();
        		p.setPumpid(pumpid);
        		p.setDtype("建筑物");
        		k = i+1;
        		p.setDnumber(k);
        		try {
        			p.setAssetname(assetnames[i]);
				} catch (Exception e) {
				}
        		try {
        			p.setSupplyer(supplyers[i]);
				} catch (Exception e) {
				}
        		try {
        			p.setDspec(dspecs[i]);
				} catch (Exception e) {
				}
        		try {
        			p.setDunit(dunits[i]);
				} catch (Exception e) {
				}
        		try {
        			p.setAreaorquantity(areaorquantitys[i]);
				} catch (Exception e) {
				}
        		try {
        			p.setRemark(remarks[i]);
				} catch (Exception e) {
				}
        		
        		p.setCreateBy(user.getLoginName());
        		detailService.insertReport(p);
			}
        	
        	size = assetname2s.length;
        	for(int j =0;j<size;j++){
        		PumpDetail p = new PumpDetail();
        		p.setPumpid(pumpid);
        		p.setDtype("设备");
        		k = k+j+1;
        		p.setDnumber(k);
        		try {
        			p.setAssetname(assetname2s[j]);
				} catch (Exception e) {
				}
        		try {
        			p.setSupplyer(supplyer2s[j]);
				} catch (Exception e) {
				}
        		try {
        			p.setDspec(dspec2s[j]);
				} catch (Exception e) {
				}
        		try {
        			p.setDunit(dunit2s[j]);
				} catch (Exception e) {
				}
        		try {
        			p.setAreaorquantity(areaorquantity2s[j]);
				} catch (Exception e) {
				}
        		try {
        			p.setRemark(remark2s[j]);
				} catch (Exception e) {
				}
        		p.setCreateBy(user.getLoginName());
        		detailService.insertReport(p);
			}
        	return success();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return error(e.getMessage());
		}
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Pump pump = service.selectReportById(id);
        List<PumpDetail> list = detailService.selectListByPumpId(id);
        List<PumpDetail> list1 = new ArrayList<PumpDetail>();
        List<PumpDetail> list2 = new ArrayList<PumpDetail>();
        
        if (null != list) {
			for (PumpDetail pumpDetail : list) {
				if (null != pumpDetail.getDtype() && pumpDetail.getDtype().equals("建筑物")) {
					list1.add(pumpDetail);
				}
				if (null != pumpDetail.getDtype() && pumpDetail.getDtype().equals("设备")) {
					list2.add(pumpDetail);
				}
			}
		}
        pump.setList1(list1);
        pump.setList2(list2);
        mmap.put("obj", pump);
        return prefix + "/edit";
    }
    
    
 
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:pump:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Pump report)
    {
    	report.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.updateReport(report));
    }

    @RequiresPermissions("report:pump:delete")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
        	detailService.deleteByPumpIds(ids);
            return toAjax(service.deleteReportByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
