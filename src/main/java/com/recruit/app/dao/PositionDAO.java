package com.recruit.app.dao;

import com.recruit.app.domain.model.PositionModel;

public interface PositionDAO {
	public PositionModel queryById(long positionId);
	
	public long addPosition(PositionModel model);
}
