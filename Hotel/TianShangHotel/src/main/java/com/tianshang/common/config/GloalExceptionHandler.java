package com.tianshang.common.config;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianshang.common.vo.JsonResult;


/**
 * 全局异常处理类(需要使用@ControllerAdvice修饰)
 * 可以在此类中添加所有Controller中
 * 需要共享的异常处理方法
 */

@ControllerAdvice
public class GloalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public JsonResult doHandleException(Exception e){
		System.out.println("全局异常处理");
		JsonResult result=new JsonResult();
		result.setState(0);
		if(e instanceof IncorrectCredentialsException){
			result.setMessage("密码错误");
			return result;
		}
		if(e instanceof AuthorizationException){
			result.setMessage("没有操作权限");
			return result;
		}
		result.setMessage(e.getMessage());
		return result;
	}
}
