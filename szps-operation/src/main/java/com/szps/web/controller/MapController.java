package com.szps.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/map")
public class MapController extends BaseController{
	private String prefix = "map/";
	
	@GetMapping("/index2")
	public String indexMap() {
		return prefix+"index2";
	}
}
