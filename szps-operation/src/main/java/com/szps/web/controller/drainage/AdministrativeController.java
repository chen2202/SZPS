package com.szps.web.controller.drainage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.web.domain.drainage.Administrative;
import com.szps.web.service.drainage.AdministrativeService;

/**
 * 行政区 控制器
 * @author zxc
 *
 */
@Controller
@RequestMapping("/drainage") 
public class AdministrativeController {
	@Autowired
	private AdministrativeService administrativeService;
	
	/**
	 * 查询全部公司名称 代码,在从业人员编辑添加时，添加到下拉菜单
	 * @return 全部公司名称 代码
	 */
    @PostMapping("/household/administrativeNameList")
    @ResponseBody
    public List<String> administrativeNameList(){
        List<Administrative> administrativeModel = administrativeService.selectAllAdministrativeName();
        List<String> administrativeInfo = new ArrayList<String>(); //存放行政区名称的List
        //遍历DRAINAGE_T_ADMINISTRATIVE表中数据，提取出行政区名称
        for(int i=0;i<administrativeModel.size();i++) { 
        	Administrative administrative = (Administrative)administrativeModel.get(i);
        	administrativeInfo.add(administrative.getAdministrative_name()); //同一个行政区名添加两次，分别作为text和value
        	administrativeInfo.add(administrative.getAdministrative_name());
        }
        return administrativeInfo;
    }
}
