package com.tianshang.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshang.common.vo.JsonResult;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
		
	}

	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(
			String adminname, 
			String password) {
		
		//获取当前的Subject
	    Subject currentUser = SecurityUtils.getSubject();
	    //测试当前用户是否已经被认证(即是否已经登录)
	    if (!currentUser.isAuthenticated()) {
	    	//将用户名与密码封装为UsernamePasswordToken对象
	        UsernamePasswordToken token = new UsernamePasswordToken(adminname, password);
	        token.setRememberMe(true);//记录用户
	        try {	            currentUser.login(token);//调用Subject的login方法执行登录
	        } catch (AuthenticationException e) {//所有认证时异常的父类
	            System.out.println("登录失败："+e.getMessage());
	        } 
	    }
		return new JsonResult("login ok");
		
		/*System.out.println(adminname+"/"+password);
		//获取当前的Subject
	    Subject currentUser = SecurityUtils.getSubject();
		// 1.对用户身份以及凭证信息进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(
				adminname, password);
		token.setRememberMe(true);//记录用户
		System.out.println("打印：" + token);
		// 2. 获取Shiro框架中的主体对象
		Subject subject = SecurityUtils.getSubject();
		// 3. 通过主体对象提交用户token信息
		subject.login(token);
		
		currentUser.login(token);
		return new JsonResult("login ok");*/
	}

}
