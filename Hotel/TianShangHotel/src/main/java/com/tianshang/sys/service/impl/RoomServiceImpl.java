package com.tianshang.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianshang.sys.dao.RoomDao;
import com.tianshang.sys.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;
		

	@Override
	public List<Map<String, Object>> findObjects() {
		// TODO Auto-generated method stub
		return roomDao.findRoomObjects();
	}

}
