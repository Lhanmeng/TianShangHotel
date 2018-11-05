package com.tianshang.sys.entity;

import java.io.Serializable;
/**
 * 员工实体类
 * @author 000
 *
 */
public class Emp implements Serializable{
	
	/**序列化*/
	private static final long serialVersionUID = 1L;
	
	/**员工id*/
	private Integer id;
	/**员工工号*/
	private Integer employeeId;
	/**员工姓名*/
	private String name;
	/**员工年龄*/
	private Integer age;
	/**员工职位*/
	private String position;
	/**地址*/
	private String addr;
	/**员工电话*/
	private String tel;
	/**外键房屋id*/
	private Integer roomId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", age=" + age + ", position="
				+ position + ", addr=" + addr + ", tel=" + tel + ", roomId=" + roomId + "]";
	}
	
	
	
	
	
	
	
	
	

}





