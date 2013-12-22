package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.EducationDO;
import com.recruit.app.domain.model.Education;

public class EducationMapper {
	public static EducationDO convertToDO(Education edu) {
		if(edu == null) {
			return null;
		}
		EducationDO eduDO = new EducationDO();
		eduDO.setBeginDate(edu.getBeginDate());
		eduDO.setDetail(edu.getDetail());
		eduDO.setEndDate(edu.getEndDate());
		eduDO.setId(edu.getId());
		eduDO.setMajor(edu.getMajor());
		eduDO.setSchool(edu.getSchool());
		return eduDO;
	}
	
	public static Education convertToModel(EducationDO eduDO) {
		if(eduDO == null) {
			return null;
		}
		Education edu = new Education();
		edu.setBeginDate(eduDO.getBeginDate());
		edu.setDetail(eduDO.getDetail());
		edu.setEndDate(eduDO.getEndDate());
		edu.setId(edu.getId());
		edu.setMajor(eduDO.getMajor());
		edu.setSchool(eduDO.getSchool());
		return edu;
	}
}
