package com.tianshang.common.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 通过此配置文件整个MVC,spirng-mvc.xml
 */
//@Configuration //可以省略(有@ComponentScan)
@ComponentScan(value="com.tianshang", 
includeFilters={//通过过滤指定只加载Controller等注解修饰的类
@Filter(classes={Controller.class,ControllerAdvice.class})},useDefaultFilters=false)//默认加载指定包下所有类
@EnableWebMvc //启用MVC默认配置
public class AppServletConfig extends WebMvcConfigurerAdapter{
	/**配置视图解析器*/
	@Override
	public void configureViewResolvers(
			ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/",".html");
	}
	 
	/**整合fastjson库(提供了操作JSON的API0)*/
	@Override
	public void configureMessageConverters(
	  List<HttpMessageConverter<?>> converters) {
      //1.构建MessageConverter对象
	  FastJsonHttpMessageConverter converter=
	  new FastJsonHttpMessageConverter();
	  //2.配置MessageConverter对象
	  //2.1设置fastjson的基本配置
	 
	  FastJsonConfig config=new FastJsonConfig();
	  config.setSerializeConfig(SerializeConfig.globalInstance);
	  //禁用循环引用问题(id)
	  config.setSerializerFeatures(
	  SerializerFeature.DisableCircularReferenceDetect);
	  converter.setFastJsonConfig(config);
	  
	  //2.2设置MessageConverter对象对媒体的支持
	  List<MediaType> list=new ArrayList<MediaType>();
	  list.add(new MediaType("text","html",
			  Charset.forName("UTF-8")));
	  list.add(new MediaType("application","json",
			  Charset.forName("UTF-8")));
	  converter.setSupportedMediaTypes(list);
	  //3.将MessageConverter对象添加到converters容器
	  converters.add(converter);
	}
}
