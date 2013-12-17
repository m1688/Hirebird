package com.recruit.app.domain.model;
import java.util.Date;

/**
 * 教育背景
 * 
 * @author wei.xinw
 * 
 */
public class Education {
	private Long id;
	private Date beginDate; // 开始时间
	private Date endDate;// 结束时间
	private String school; // 学习名称
	private String major; // 专业
	private String detail; // 教育详情描述

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
