package com.szps.web.controller.report;

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
import com.szps.common.core.text.Convert;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.report.OpLog;
import com.szps.web.domain.report.PsProgressN;
import com.szps.web.service.report.IPsProgressNService;

@Controller
@RequestMapping("/op/report/psprogress")
public class PsProgressController extends BaseController {
	 @Autowired
	private IPsProgressNService service;
	
	private String prefix = "/report/psprogress";
	
    @RequiresPermissions("report:psprogress:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("report:psprogress:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PsProgressN obj)
    {
        startPage();
        List<PsProgressN> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    @RequiresPermissions("report:psprogress:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( PsProgressN obj,@RequestParam("xzqy_q")String[] xzqy_qs,
    		@RequestParam("xzqy_j")String[] xzqy_js,
    		@RequestParam("duedate")String[] duedates,
    		@RequestParam("buildingtype")String[] buildingtypes,
    		@RequestParam("jzxq_s")String[] jzxq_ss,
    		@RequestParam("jzxq_q")String[] jzxq_qs,
    		@RequestParam("jzxq_y")String[] jzxq_ys,
    		@RequestParam("jzxq_z")String[] jzxq_zs,
    		@RequestParam("psgwg_h")String[] psgwg_hs,
    		@RequestParam("psgwg_y")String[] psgwg_ys,
    		@RequestParam("psgwg_w")String[] psgwg_ws,
    		@RequestParam("gwch_wg_xq")String[] gwch_wg_xqs,
    		@RequestParam("gwch_wg_h")String[] gwch_wg_hs,
    		@RequestParam("gwch_wg_y")String[] gwch_wg_ys,
    		@RequestParam("gwch_wg_w")String[] gwch_wg_ws,
    		@RequestParam("gwch_zzkz_xq")String[] gwch_zzkz_xqs,
    		@RequestParam("gwch_zzkz_h")String[] gwch_zzkz_hs,
    		@RequestParam("gwch_zzkz_y")String[] gwch_zzkz_ys,
    		@RequestParam("gwch_zzkz_w")String[] gwch_zzkz_ws,
    		@RequestParam("gwzc_wg_xq")String[] gwzc_wg_xqs,
    		@RequestParam("gwzc_wg_h")String[] gwzc_wg_hs,
    		@RequestParam("gwzc_wg_y")String[] gwzc_wg_ys,
    		@RequestParam("gwzc_wg_w")String[] gwzc_wg_ws,
    		@RequestParam("gwzc_zzkz_xq")String[] gwzc_zzkz_xqs,
    		@RequestParam("gwzc_zzkz_h")String[] gwzc_zzkz_hs,
    		@RequestParam("gwzc_zzkz_y")String[] gwzc_zzkz_ys,
    		@RequestParam("gwzc_zzkz_w")String[] gwzc_zzkz_ws,
    		@RequestParam("gwqy_wg_xq")String[] gwqy_wg_xqs,
    		@RequestParam("gwqy_wg_h")String[] gwqy_wg_hs,
    		@RequestParam("gwqy_wg_y")String[] gwqy_wg_ys,
    		@RequestParam("gwqy_wg_w")String[] gwqy_wg_ws,
    		@RequestParam("gwqy_wg_qy")String[] gwqy_wg_qys,
    		@RequestParam("gwqy_zzkz_xq")String[] gwqy_zzkz_xqs,
    		@RequestParam("gwqy_zzkz_h")String[] gwqy_zzkz_hs,
    		@RequestParam("gwqy_zzkz_y")String[] gwqy_zzkz_ys,
    		@RequestParam("gwqy_zzkz_w")String[] gwqy_zzkz_ws,
    		@RequestParam("gwqy_zzkz_qy")String[] gwqy_zzkz_qys,
    		@RequestParam("gwxf_wg_xq")String[] gwxf_wg_xqs,
    		@RequestParam("gwxf_wg_h")String[] gwxf_wg_hs,
    		@RequestParam("gwxf_wg_y")String[] gwxf_wg_ys,
    		@RequestParam("gwxf_wg_w")String[] gwxf_wg_ws,
    		@RequestParam("gwxf_wg_hld")String[] gwxf_wg_hlds,
    		@RequestParam("gwxf_zzkz_xq")String[] gwxf_zzkz_xqs,
    		@RequestParam("gwxf_zzkz_h")String[] gwxf_zzkz_hs,
    		@RequestParam("gwxf_zzkz_y")String[] gwxf_zzkz_ys,
    		@RequestParam("gwxf_zzkz_w")String[] gwxf_zzkz_ws,
    		@RequestParam("gwxf_zzkz_hld")String[] gwxf_zzkz_hlds,
    		@RequestParam("jcj_h")String[] jcj_hs,
    		@RequestParam("jcj_y")String[] jcj_ys,
    		@RequestParam("jcj_w")String[] jcj_ws,
    		@RequestParam("ysk")String[] ysks,
    		@RequestParam("psh_h")String[] psh_hs,
    		@RequestParam("psh_y")String[] psh_ys,
    		@RequestParam("psh_e")String[] psh_es,
    		@RequestParam("hfc")String[] hfcs,
    		@RequestParam("ljc")String[] ljcs,
    		@RequestParam("gyc")String[] gycs
)
    {
    	
        
        try {
        	SysUser user = ShiroUtils.getSysUser();
        	int size = buildingtypes.length;
        	for(int i =0;i<size;i++){
        		PsProgressN p = new PsProgressN();
        		p.setDept_id(user.getDeptId());
        		p.setCreateBy(user.getLoginName());
        		p.setXzqy_q(obj.getXzqy_q());
        		p.setXzqy_j(obj.getXzqy_j());
        		p.setDuedate(obj.getDuedate());
        		p.setCreateBy(user.getLoginName());
        		p.setBuildingtype(buildingtypes[i]);
        		p.setJzxq_s(jzxq_ss[i]);
        		p.setJzxq_q(jzxq_qs[i]);
        		p.setJzxq_y(jzxq_ys[i]);
        		p.setJzxq_z(jzxq_zs[i]);
        		p.setPsgwg_h(psgwg_hs[i]);
        		p.setPsgwg_y(psgwg_ys[i]);
        		p.setPsgwg_w(psgwg_ws[i]);
        		p.setGwch_wg_xq(gwch_wg_xqs[i]);
        		p.setGwch_wg_h(gwch_wg_hs[i]);
        		p.setGwch_wg_y(gwch_wg_ys[i]);
        		p.setGwch_wg_w(gwch_wg_ws[i]);
        		p.setGwch_zzkz_xq(gwch_zzkz_xqs[i]);
        		p.setGwch_zzkz_h(gwch_zzkz_hs[i]);
        		p.setGwch_zzkz_y(gwch_zzkz_ys[i]);
        		p.setGwch_zzkz_w(gwch_zzkz_ws[i]);
        		p.setGwzc_wg_xq(gwzc_wg_xqs[i]);
        		p.setGwzc_wg_h(gwzc_wg_hs[i]);
        		p.setGwzc_wg_y(gwzc_wg_ys[i]);
        		p.setGwzc_wg_w(gwzc_wg_ws[i]);
        		p.setGwzc_zzkz_xq(gwzc_zzkz_xqs[i]);
        		p.setGwzc_zzkz_h(gwzc_zzkz_hs[i]);
        		p.setGwzc_zzkz_y(gwzc_zzkz_ys[i]);
        		p.setGwzc_zzkz_w(gwzc_zzkz_ws[i]);
        		p.setGwqy_wg_xq(gwqy_wg_xqs[i]);
        		p.setGwqy_wg_h(gwqy_wg_hs[i]);
        		p.setGwqy_wg_y(gwqy_wg_ys[i]);
        		p.setGwqy_wg_w(gwqy_wg_ws[i]);
        		p.setGwqy_wg_qy(gwqy_wg_qys[i]);
        		p.setGwqy_zzkz_xq(gwqy_zzkz_xqs[i]);
        		p.setGwqy_zzkz_h(gwqy_zzkz_hs[i]);
        		p.setGwqy_zzkz_y(gwqy_zzkz_ys[i]);
        		p.setGwqy_zzkz_w(gwqy_zzkz_ws[i]);
        		p.setGwqy_zzkz_qy(gwqy_zzkz_qys[i]);
        		
        		p.setGwxf_wg_xq(gwxf_wg_xqs[i]);
        		p.setGwxf_wg_h(gwxf_wg_hs[i]);
        		p.setGwxf_wg_y(gwxf_wg_ys[i]);
        		p.setGwxf_wg_w(gwxf_wg_ws[i]);
        		p.setGwxf_wg_hld(gwxf_wg_hlds[i]);
        		
        		p.setGwxf_zzkz_xq(gwxf_zzkz_xqs[i]);
        		p.setGwxf_zzkz_h(gwxf_zzkz_hs[i]);
        		p.setGwxf_zzkz_y(gwxf_zzkz_ys[i]);
        		p.setGwxf_zzkz_w(gwxf_zzkz_ws[i]);
        		p.setGwxf_zzkz_hld(gwxf_zzkz_hlds[i]);
        		
        		p.setJcj_h(jcj_hs[i]);
        		p.setJcj_y(jcj_ys[i]);
        		p.setJcj_w(jcj_ws[i]);
        		
        		p.setYsk(ysks[i]);
        		
        		p.setPsh_h(psh_hs[i]);
        		p.setPsh_y(psh_ys[i]);
        		p.setPsh_e(psh_es[i]);
        		p.setHfc(hfcs[i]);
        		p.setLjc(ljcs[i]);
        		p.setGyc(gycs[i]);
        		service.insert(p);
        		
        	}
        	return success();
		} catch (Exception e) {
			return error();
		}
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	PsProgressN obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:psprogress:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated PsProgressN obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("report:psprogress:delete")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
		/*
		 * Long[] idsL = Convert.toLongArray(ids); for (int i = 0; i < idsL.length; i++)
		 * { PsProgressN progressN = service.selectById(idsL[i]); String a =
		 * progressN.getDuedate(); String b = progressN.getXzqy_q(); String c =
		 * progressN.getXzqy_j();
		 * 
		 * 
		 * } service.selectById(id)
		 */
        try
        {
            return toAjax(service.deleteByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
