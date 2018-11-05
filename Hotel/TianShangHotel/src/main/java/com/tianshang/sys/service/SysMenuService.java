package com.tianshang.sys.service;

import java.util.List;
import com.tianshang.common.vo.Node;


public interface SysMenuService {
	
	

    /**
     * 查询菜单节点信息
     * @return
     */
	public List<Node> findZtreeMenuNodes();

	
}







