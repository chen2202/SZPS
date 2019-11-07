package com.szps.web.controller.drainage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.web.domain.drainage.Committees;
import com.szps.web.service.drainage.CommitteesService;

@Controller
@RequestMapping("/drainage")
public class CommitteesController {
	@Autowired
	private CommitteesService committeesService;
	
	/**
	 * 获取某个街道全部居委会名称（用于下拉菜单）
	 *
	 */
	@PostMapping("/household/committeesNameList")
    @ResponseBody
    public List<String> committeesNameList(Committees committees){
		List<Committees> committeesModel = committeesService.selectSomeCommittees(committees);
		List<String> committeesInfo = new ArrayList<String>(); //存放某街道全部居委会名称
		for(int i=0;i<committeesModel.size();i++) {
			Committees c = committeesModel.get(i);
			committeesInfo.add(c.getCommittees()); //添加两次居委会名，分别用于text和value
			committeesInfo.add(c.getCommittees());
		}
		return committeesInfo;
	} 
}
