package com.tianshang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room/")
public class RoomController {
	
	@RequestMapping("doRoomListUI")
	public String doRoomListUI(){
		return "sys/room_list";
	}
	
}