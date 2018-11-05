package com.tianshang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	 
	@RequestMapping("doEmpListUI")
	public String doEmpListUI(){
		return "sys/emp_user_list";
	}
}
