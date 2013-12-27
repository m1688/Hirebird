package com.recruit.app.service;

import java.util.List;

import com.recruit.app.domain.model.PositionModel;

public interface PositionService {

    public PositionModel queryPositionById(long positionId);

    public long addPosition(PositionModel position);

    /**
     * 以职位名称进行模糊查询，可不传,一次查50条
     * 
     * @param title
     * @return
     */
    public List<PositionModel> queryList(String title);

}
