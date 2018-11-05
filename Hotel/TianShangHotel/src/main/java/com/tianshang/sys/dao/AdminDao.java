package com.tianshang.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.tianshang.sys.entity.Admin;

public interface AdminDao {
	
	 Admin findAdminByAdminName(String adminname);
	 
	 int validById(@Param("id") Integer id,
			 @Param("valid") Integer valid,
			 @Param("modifiedUser") String modifiedUser);


}
