package com.recruit.app.db.dataobject;

import static com.recruit.app.db.tables.Resume.CONTACT_ID;
import static com.recruit.app.db.tables.Resume.EDUCATIONS;
import static com.recruit.app.db.tables.Resume.EXP_DETAIL;
import static com.recruit.app.db.tables.Resume.JOB_TARGET;
import static com.recruit.app.db.tables.Resume.SKILL_DETAIL;
import static com.recruit.app.db.tables.Resume.USER;
import static com.recruit.app.db.tables.Resume.WORK_EXPS;

import java.io.Serializable;

import android.content.ContentValues;
/**
 * 简历模型
 * 
 * @author wei.xinw
 * 
 */
public class ResumeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private long user; // 用户基本信息
	private long contact; // 联系方式
	private String education; // 教育经历,逗号分隔的id
	private String skillDetail; // 基本技能详细
	private String experience; // 工作经历，逗号分隔的id
	private String experienceDetail; // 工作经历详细描述
	private long target; // 求职目标
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSkillDetail() {
		return skillDetail;
	}
	public void setSkillDetail(String skillDetail) {
		this.skillDetail = skillDetail;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getExperienceDetail() {
		return experienceDetail;
	}
	public void setExperienceDetail(String experienceDetail) {
		this.experienceDetail = experienceDetail;
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}

	/**
	 * 将字段转换成CententValues
	 * @return
	 */
	public ContentValues toContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(CONTACT_ID, contact);
		cv.put(EDUCATIONS, education);
		cv.put(EXP_DETAIL, experienceDetail);
		cv.put(JOB_TARGET, target);
		cv.put(SKILL_DETAIL, skillDetail);
		cv.put(USER, user);
		cv.put(WORK_EXPS, experience);
		return cv;
	}
}
