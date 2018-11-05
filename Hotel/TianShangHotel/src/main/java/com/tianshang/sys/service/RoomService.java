package com.tianshang.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface RoomService {
	
	 List<Map<String,Object>> findObjects();
}
