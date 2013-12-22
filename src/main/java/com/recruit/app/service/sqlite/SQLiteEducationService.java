package com.recruit.app.service.sqlite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.recruit.app.dao.EducationDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.EducationDO;
import com.recruit.app.domain.model.Education;
import com.recruit.app.service.EducationService;
import com.recruit.app.service.mapper.EducationMapper;

public class SQLiteEducationService implements EducationService {
	private EducationDAO eduDAO = DAOFactory.getInstance().getEducationDAO();
	public long addEducation(Education edu) {
		EducationDO educationDO = EducationMapper.convertToDO(edu);
		return eduDAO.addEducation(educationDO);
	}

	public Education queryEducationById(long id) {
		EducationDO educationDO = eduDAO.queryById(id);
		return EducationMapper.convertToModel(educationDO);
	}

	public List<Education> queryEducationByIdList(List<Long> idList) {
		List<EducationDO> eduDOList = eduDAO.queryByIds(idList);
		if(eduDOList == null || eduDOList.size() == 0) {
			return Collections.emptyList();
		}
		
		List<Education> eduList = new ArrayList<Education>(eduDOList.size());
		for(EducationDO eduDO : eduDOList) {
			eduList.add(EducationMapper.convertToModel(eduDO));
		}
		return eduList;
	}

}
