package com.szps.web.controller.drainage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.web.domain.drainage.Street;
import com.szps.web.service.drainage.StreetService;

@Controller
@RequestMapping("/drainage")
public class StreetController {
	@Autowired
	private StreetService streetService;
	
	/**
	 * 获取某个行政区全部街道名称（用于下拉菜单）
	 *
	 */
	@PostMapping("/household/streetNameList")
    @ResponseBody
    public List<String> streetNameList(Street street){
		List<Street> streetModel = streetService.selectSomeStreet(street);
		List<String> streetInfo = new ArrayList<String>(); //存放某行政区全部街道名称
		for(int i=0;i<streetModel.size();i++) {
			Street s = streetModel.get(i);
			streetInfo.add(s.getStreet_name()); //添加两次街道名，分别用于text和value
			streetInfo.add(s.getStreet_name());
		}
		return streetInfo;
	} 
}
