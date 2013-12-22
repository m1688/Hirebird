package com.recruit.app.dao;

import java.util.List;

import com.recruit.app.db.dataobject.EducationDO;

public interface EducationDAO {
	public long addEducation(EducationDO educationDO);
	public EducationDO queryById(long educationId);
	public List<EducationDO> queryByIds(List<Long> educationIdList);
}
