package com.recruit.app.db.dataobject;
import static com.recruit.app.db.tables.JobTarget.EXPECT_SALARY;
import static com.recruit.app.db.tables.JobTarget.ID;
import static com.recruit.app.db.tables.JobTarget.INDUSTRY;
import static com.recruit.app.db.tables.JobTarget.POSITION;
import static com.recruit.app.db.tables.JobTarget.WORK_CITY;
import android.content.ContentValues;

/**
 * 求职目标
 * 
 * @author wei.xinw
 * 
 */
public class JobTargetDO {
	private long id;
	private String industry; // 意向行业
	private String position; // 意向岗位
	private String workCity; // 意向工作地点
	private String expectSalary; // 期望月薪

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getExpectSalary() {
		return expectSalary;
	}

	public void setExpectSalary(String expectSalary) {
		this.expectSalary = expectSalary;
	}

	/**
	 * 返回字段的ContentValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(INDUSTRY, industry);
		cv.put(POSITION, position);
		cv.put(WORK_CITY, workCity);
		cv.put(EXPECT_SALARY, expectSalary);
		return cv;
	}
}
