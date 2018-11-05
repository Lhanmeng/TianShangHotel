package com.tianshang.sys.service;

import com.tianshang.sys.entity.Emp;
import com.tianshang.sys.entity.PageObject;

public interface EmpService {
	
	 /**
     * 通过此方法实现分页查询操作
     * @param name 基于条件查询时的参数名
     * @param pageCurrent 当前的页码值
     * @return 当前页记录+分页信息
     */
	 PageObject<Emp> findPageObjects(
			 String name,
			 Integer pageCurrent);

	 

}
