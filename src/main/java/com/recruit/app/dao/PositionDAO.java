package com.recruit.app.dao;

import java.util.List;

import com.recruit.app.db.dataobject.PositionDO;

public interface PositionDAO {

    public PositionDO queryById(long positionId);

    public long addPosition(PositionDO model);

    public List<PositionDO> queryList(String title);
}
