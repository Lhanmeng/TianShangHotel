package com.tianshang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";
	}
	/**此方法用于返回分页页面*/
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
}
