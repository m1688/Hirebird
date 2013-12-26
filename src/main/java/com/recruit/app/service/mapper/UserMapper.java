package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.UserDO;
import com.recruit.app.domain.model.User;
import com.recruit.app.service.AccountService;
import com.recruit.app.service.factory.ServiceFactory;

public class UserMapper {
	private static AccountService accountService = ServiceFactory.getInstance().getAccountService();
	
	public static UserDO convertToDO(User user) {
		if(user == null) {
			return null;
		}
		UserDO userDO = new UserDO();
		userDO.setAccount(user.getAccount().getId());
		userDO.setBirthday(user.getBirthday());
		userDO.setCreateDate(userDO.getCreateDate());
		userDO.setDegree(userDO.getDegree());
		userDO.setEnglishLevel(userDO.getEnglishLevel());
		userDO.setId(userDO.getId());
		userDO.setIdNum(userDO.getIdNum());
		userDO.setIdType(userDO.getIdType());
		userDO.setMajor(userDO.getMajor());
		userDO.setModifyDate(userDO.getModifyDate());
		userDO.setName(userDO.getName());
		userDO.setSex(userDO.getSex());
		userDO.setWorkingYear(userDO.getWorkingYear());
		return userDO;
	}
	
	public static User convertToModel(UserDO userDO) {
		if(userDO == null) {
			return null;
		}
		User user = new User();
		user.setAccount(accountService.queryAccountById(userDO.getAccount()));
		user.setBirthday(userDO.getBirthday());
		user.setCreateDate(userDO.getCreateDate());
		user.setDegree(userDO.getDegree());
		user.setEnglishLevel(userDO.getEnglishLevel());
		user.setId(userDO.getId());
		user.setIdNum(userDO.getIdNum());
		user.setIdType(userDO.getIdType());
		user.setMajor(userDO.getMajor());
		user.setModifyDate(userDO.getModifyDate());
		user.setName(userDO.getName());
		user.setSex(userDO.getSex());
		user.setWorkingYear(userDO.getWorkingYear());
		return user;
	}
}
