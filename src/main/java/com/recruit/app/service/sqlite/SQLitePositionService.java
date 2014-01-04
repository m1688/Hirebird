package com.recruit.app.service.sqlite;

import java.util.ArrayList;
import java.util.List;

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

    // 以职位名称进行模糊查询，可不传,一次查50条
    public List<PositionModel> queryList(String title) {
        List<PositionModel> positionModelList = new ArrayList<PositionModel>();
        List<PositionDO> positionDOList = positionDAO.queryList(title);
        if (positionDOList == null || positionDOList.size() == 0) {
            return positionModelList;
        }
        for (PositionDO positionDO : positionDOList) {
            PositionModel positionModel = PositionMapper.convertToModel(positionDO);
            positionModelList.add(positionModel);
        }
        return positionModelList;

    }
}
