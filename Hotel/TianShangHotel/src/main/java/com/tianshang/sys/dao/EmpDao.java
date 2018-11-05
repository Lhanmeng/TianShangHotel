package com.tianshang.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianshang.sys.entity.Emp;

public interface EmpDao {
		
		List<Emp> findPageObjects(
					@Param("name")String name,
					@Param("startIndex")Integer startIndex,
					@Param("pageSize")Integer pageSize);
			
		int getRowCount(@Param("name")String name);
		


}
