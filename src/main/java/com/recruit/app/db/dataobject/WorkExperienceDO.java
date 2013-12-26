package com.recruit.app.db.dataobject;

import static com.recruit.app.db.tables.WorkExperience.BEGIN;
import static com.recruit.app.db.tables.WorkExperience.COMPANY;
import static com.recruit.app.db.tables.WorkExperience.DETAIL;
import static com.recruit.app.db.tables.WorkExperience.END;
import static com.recruit.app.db.tables.WorkExperience.IS_PRIVATE;
import static com.recruit.app.db.tables.WorkExperience.ON_JOB;
import static com.recruit.app.db.tables.WorkExperience.POSITION;
import static com.recruit.app.db.tables.WorkExperience.SALARY;

import java.util.Date;

import android.content.ContentValues;

import com.recruit.app.util.DateUtil;
/**
 * 工作经历
 * 
 * @author wei.xinw
 * 
 */
public class WorkExperienceDO {
	private long id;
	private String company; // 公司名称
	private String position; // 职位
	private boolean isJob; // 是否在职
	private Date begin; // 入职时间
	private Date end; // 离职时间
	private int salary; // 月薪
	private boolean isPrivate; // 是否保密
	private String detail; // 岗位详情介绍

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	/**
	 * 将字段转换成CententValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(BEGIN, DateUtil.formatDate(begin));
		cv.put(COMPANY, company);
		cv.put(DETAIL, detail);
		cv.put(END, DateUtil.formatDate(end));
		cv.put(IS_PRIVATE, isPrivate);
		cv.put(ON_JOB, isJob);
		cv.put(POSITION, position);
		cv.put(SALARY, salary);
		return cv;
	}
}
