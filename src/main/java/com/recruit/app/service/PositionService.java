package com.recruit.app.service;

import com.recruit.app.domain.model.PositionModel;

public interface PositionService {
	public PositionModel queryPositionById(long positionId);
	public long addPosition(PositionModel position);
}
