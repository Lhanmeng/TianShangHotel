package com.tianshang.sys.entity;

import java.util.Date;

public class Room {
	private Integer roomId;
	private String type;
	private double price;
	private String status;
	private Date updateTime;
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", type=" + type + ", price=" + price + ", status=" + status + ", updateTime="
				+ updateTime + "]";
	}
}
