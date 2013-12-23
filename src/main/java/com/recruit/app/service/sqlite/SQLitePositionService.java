package com.recruit.app.service.sqlite;

import com.recruit.app.dao.PositionDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.PositionDO;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.service.PositionService;
import com.recruit.app.service.mapper.PositionMapper;

public class SQLitePositionService implements PositionService {
	private PositionDAO positionDAO = DAOFactory.getInstance().getPositionDAO();
	
	public PositionModel queryPositionById(long positionId) {
		PositionDO positionDO = positionDAO.queryById(positionId);
		return PositionMapper.convertToModel(positionDO);
	}

	public long addPosition(PositionModel position) {
		PositionDO positionDO = PositionMapper.convertToDO(position);
		return positionDAO.addPosition(positionDO);
	}

}
