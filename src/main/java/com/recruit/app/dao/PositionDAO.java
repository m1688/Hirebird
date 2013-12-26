package com.recruit.app.dao;

import com.recruit.app.db.dataobject.PositionDO;

public interface PositionDAO {
	public PositionDO queryById(long positionId);
	
	public long addPosition(PositionDO model);
}
