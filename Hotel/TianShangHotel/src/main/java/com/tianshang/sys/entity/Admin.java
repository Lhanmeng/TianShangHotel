package com.tianshang.sys.entity;

import java.io.Serializable;

public class Admin  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4625278640656819803L;
	private Integer id;
	private String adminname;
	private String password;
	private String salt;//盐值
	
	private Integer valid = 1;
	
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + ", salt=" + salt + ", valid="
				+ valid + "]";
	}



}
