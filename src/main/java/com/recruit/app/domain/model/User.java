package com.recruit.app.domain.model;


import java.util.Date;

import android.content.ContentValues;
import static com.recruit.app.db.tables.User.BIRTHDAY;
import static com.recruit.app.db.tables.User.CREATE_DATE;
import static com.recruit.app.db.tables.User.DEGREE;
import static com.recruit.app.db.tables.User.ENGLISH_LEVEL;
import static com.recruit.app.db.tables.User.ID_NUM;
import static com.recruit.app.db.tables.User.ID_TYPE;
import static com.recruit.app.db.tables.User.MAJOR;
import static com.recruit.app.db.tables.User.MODIFY_DATE;
import static com.recruit.app.db.tables.User.NAME;
import static com.recruit.app.db.tables.User.SEX;
import static com.recruit.app.db.tables.User.WORK_YEAR;
/**
 * 用户信息
 * 
 * @author wei.xinw
 * 
 */
public class User {
	private long id;
	private String name;// 真实姓名
	private int sex;// 性别，0男，1女，2人妖
	private Date birthday;// 出生日期
	private String idType;// 证件类型
	private String idNum;// 证件号码
	private String degree;// 最高学位，todo:提取枚举类型
	private String major;// 主修专业
	private String englishLevel;// 英语水平，等级，如四，六级，专业八级等，todo:提取枚举
	private int workingYear;// 工作年限
	private Date createDate;// 创建时间
	private Date modifyDate;// 修改时间

	private Account account; // 账号信息

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	public int getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(int workingYear) {
		this.workingYear = workingYear;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * 将字段转换成CententValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(NAME, name);
		cv.put(SEX, sex);
		cv.put(BIRTHDAY, birthday == null ? 0 : birthday.getTime());
		cv.put(ID_TYPE, idType);
		cv.put(ID_NUM, idNum);
		cv.put(DEGREE, degree);
		cv.put(MAJOR, major);
		cv.put(ENGLISH_LEVEL, englishLevel);
		cv.put(WORK_YEAR, workingYear);
		cv.put(CREATE_DATE, createDate == null ? 0 : createDate.getTime());
		cv.put(MODIFY_DATE, modifyDate == null ? 0 : modifyDate.getTime());
		return cv;
	}
}