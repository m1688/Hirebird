package com.recruit.app.model;

import java.util.Date;

/**
 * 工作经历
 * 
 * @author wei.xinw
 * 
 */
public class WorkExperience {
	private Long id;
	private String company; // 公司名称
	private String position; // 职位
	private boolean isJob; // 是否在职
	private Date begin; // 入职时间
	private Date end; // 离职时间
	private int salary; // 月薪
	private boolean isPrivate; // 是否保密
	private String detail; // 岗位详情介绍

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isJob() {
		return isJob;
	}

	public void setJob(boolean isJob) {
		this.isJob = isJob;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
