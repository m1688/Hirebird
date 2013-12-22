package com.recruit.app.db.dataobject;
import java.util.Date;

import com.recruit.app.util.DateUtil;

import android.content.ContentValues;
import static com.recruit.app.db.tables.Education.BEGIN_DATE;
import static com.recruit.app.db.tables.Education.DETAIL;
import static com.recruit.app.db.tables.Education.END_DATE;
import static com.recruit.app.db.tables.Education.MAJOR;
import static com.recruit.app.db.tables.Education.SCHOOL;
/**
 * 教育背景
 * 
 * @author wei.xinw
 * 
 */
public class EducationDO {
	private long id;
	private Date beginDate; // 开始时间
	private Date endDate;// 结束时间
	private String school; // 学习名称
	private String major; // 专业
	private String detail; // 教育详情描述

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	/**
	 * 返回字段的ContentValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(BEGIN_DATE, DateUtil.formatDate(beginDate));
		cv.put(DETAIL, detail);
		cv.put(END_DATE, DateUtil.formatDate(endDate));
		cv.put(MAJOR, major);
		cv.put(SCHOOL, school);
		return cv;
	}
}
