package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.PositionDO;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.service.CompanyService;
import com.recruit.app.service.UserService;
import com.recruit.app.service.factory.ServiceFactory;

public class PositionMapper {

    private static CompanyService companyService = ServiceFactory.getInstance().getCompanyService();
    private static UserService    userService    = ServiceFactory.getInstance().getUserService();

    public static PositionDO convertToDO(PositionModel position) {
        if (position == null) {
            return null;
        }
        PositionDO positionDO = new PositionDO();
        positionDO.setCompany(position.getCompany().getId());
        positionDO.setDetail(position.getDetail());
        positionDO.setFunction(position.getFunction());
        positionDO.setId(position.getId());
        positionDO.setLocation(position.getLocation());
        positionDO.setLowestDegree(position.getLowestDegree());
        positionDO.setPostDate(position.getPostDate());
//        positionDO.setPublisher(position.getPublisher().getId());
        positionDO.setQuantity(position.getQuantity());
        positionDO.setSalary(position.getSalary());
        positionDO.setSkill(position.getSkill());
        positionDO.setWorkYear(position.getWorkYear());
        positionDO.setTitle(position.getTitle());
        return positionDO;
    }

    public static PositionModel convertToModel(PositionDO positionDO) {
        if (positionDO == null) {
            return null;
        }
        PositionModel position = new PositionModel();
        position.setCompany(companyService.queryCompanyById(positionDO.getCompany()));
        position.setDetail(positionDO.getDetail());
        position.setFunction(positionDO.getFunction());
        position.setId(positionDO.getId());
        position.setLocation(positionDO.getLocation());
        position.setLowestDegree(positionDO.getLowestDegree());
        position.setPostDate(positionDO.getPostDate());
        position.setPublisher(userService.queryById(positionDO.getPublisher()));
        position.setQuantity(positionDO.getQuantity());
        position.setSalary(positionDO.getSalary());
        position.setSkill(positionDO.getSkill());
        position.setWorkYear(positionDO.getWorkYear());
        position.setTitle(positionDO.getTitle());
        return position;
    }
}
