package com.recruit.app.domain.model;

import static com.recruit.app.db.tables.Position.COMPANY;
import static com.recruit.app.db.tables.Position.DETAIL;
import static com.recruit.app.db.tables.Position.FUNCTION;
import static com.recruit.app.db.tables.Position.LOCATION;
import static com.recruit.app.db.tables.Position.LOWEST_DEGREE;
import static com.recruit.app.db.tables.Position.POST_DATE;
import static com.recruit.app.db.tables.Position.PUBLISHER;
import static com.recruit.app.db.tables.Position.QUANTITY;
import static com.recruit.app.db.tables.Position.SALARY;
import static com.recruit.app.db.tables.Position.SKILL;
import static com.recruit.app.db.tables.Position.WORK_YEAR;

import java.io.Serializable;
import java.util.Date;

import android.content.ContentValues;

/**
 * 职位模型
 * 
 * @author wei.xinw
 * 
 */
public class PositionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private User publisher;// 岗位发布人
	private Company company;// 公司信息
	private Date postDate;// 发布时间
	private String location;// 工作地点
	private int workYear;// 工作年限
	private int quantity;// 招聘人数
	private String lowestDegree;// 学历要求
	private String function;// 职位职能
	private String detail;// 职位详情
	private String skill;// 任职要求，基本技能
	private String salary;// 薪资待遇

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getWorkYear() {
		return workYear;
	}

	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLowestDegree() {
		return lowestDegree;
	}

	public void setLowestDegree(String lowestDegree) {
		this.lowestDegree = lowestDegree;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * 将字段转换成ContentValues
	 * 
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(PUBLISHER, publisher.getId());
		cv.put(COMPANY, company.getId());
		cv.put(POST_DATE, postDate == null ? 0 : postDate.getTime());
		cv.put(LOCATION, location);
		cv.put(WORK_YEAR, workYear);
		cv.put(QUANTITY, quantity);
		cv.put(LOWEST_DEGREE, lowestDegree);
		cv.put(FUNCTION, function);
		cv.put(DETAIL, detail);
		cv.put(SKILL, skill);
		cv.put(SALARY, salary);
		return cv;
	}
}
