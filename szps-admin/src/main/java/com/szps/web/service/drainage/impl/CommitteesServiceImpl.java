package com.szps.web.service.drainage.impl;

import com.szps.web.domain.drainage.Committees;
import com.szps.web.mapper.drainage.CommitteesMapper;
import com.szps.web.service.drainage.CommitteesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteesServiceImpl implements CommitteesService{
	@Autowired
	private CommitteesMapper committeesMapper;
	
	/**
	 * 获取某个街道全部居委会名称（用于下拉菜单）
	 * @param committees
	 * @return
	 */
	public List<Committees> selectSomeCommittees(Committees committees){
		return committeesMapper.selectSomeCommittees(committees);
	}
}
