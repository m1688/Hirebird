package com.recruit.app.db.dataobject;

import java.io.Serializable;

import android.content.ContentValues;
import static com.recruit.app.db.tables.Account.EMAIL;
import static com.recruit.app.db.tables.Account.MOBILE_PHONE;
import static com.recruit.app.db.tables.Account.PASSWORD;
import static com.recruit.app.db.tables.Account.USERNAME;

/**
 * 账号信息
 * 
 * @author wei.xinw
 * 
 */
public class AccountDO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String userName;
	private String email;
	private String mobilePhone;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	/**
	 * 返回字段的ContentValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(EMAIL, email);
		cv.put(USERNAME, userName);
		cv.put(MOBILE_PHONE, mobilePhone);
		cv.put(PASSWORD, password);
		return cv;
	}
}
