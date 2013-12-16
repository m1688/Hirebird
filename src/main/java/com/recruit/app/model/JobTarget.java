package com.recruit.app.model;
/**
 * 求职目标
 * 
 * @author wei.xinw
 * 
 */
public class JobTarget {

	private String industry; // 意向行业
	private String position; // 意向岗位
	private String workCity; // 意向工作地点
	private String expectSalary; // 期望月薪

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

}
