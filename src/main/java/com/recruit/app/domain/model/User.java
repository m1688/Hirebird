package com.recruit.app.domain.model;


import java.util.Date;

/**
 * 用户信息
 * 
 * @author wei.xinw
 * 
 */
public class User {
	private Long id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}