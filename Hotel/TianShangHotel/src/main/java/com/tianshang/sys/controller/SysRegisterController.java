package com.tianshang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register/")
public class SysRegisterController {
	@RequestMapping("doRegisterListUI")
	public String doRegisterListUI(){
		return "sys/register_list";
	}
}
