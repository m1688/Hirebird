package com.recruit.app.service;

import java.util.List;

import com.recruit.app.domain.model.Education;

public interface EducationService {
	public long addEducation(Education edu);
	public Education queryEducationById(long id);
	public List<Education> queryEducationByIdList(List<Long> idList);
}
