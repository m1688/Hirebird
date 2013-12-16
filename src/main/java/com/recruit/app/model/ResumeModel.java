package com.recruit.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * 简历模型
 * 
 * @author wei.xinw
 * 
 */
public class ResumeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private User user; // 用户基本信息
	private Contact contact; // 联系方式
	private List<Education> education; // 教育经历
	private String skillDetail; // 基本技能详细
	private List<WorkExperience> experience; // 工作经历
	private String experienceDetail; // 教育经历详细描述
	private JobTarget target; // 求职目标

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public String getSkillDetail() {
		return skillDetail;
	}

	public void setSkillDetail(String skillDetail) {
		this.skillDetail = skillDetail;
	}

	public List<WorkExperience> getExperience() {
		return experience;
	}

	public void setExperience(List<WorkExperience> experience) {
		this.experience = experience;
	}

	public String getExperienceDetail() {
		return experienceDetail;
	}

	public void setExperienceDetail(String experienceDetail) {
		this.experienceDetail = experienceDetail;
	}

	public JobTarget getTarget() {
		return target;
	}

	public void setTarget(JobTarget target) {
		this.target = target;
	}

}
