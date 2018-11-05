package com.tianshang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alert/")
public class SysAlterController {
	@RequestMapping("doAlertListUI")
	public String doAlertListUI(){
		return "sys/alert_list";
		
	}
}
