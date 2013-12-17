package com.recruit.app.domain.model;

import java.io.Serializable;

/**
 * 账号信息
 * 
 * @author wei.xinw
 * 
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String email;
	private String mobilePhone;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
