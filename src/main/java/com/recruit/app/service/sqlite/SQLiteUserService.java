package com.recruit.app.service.sqlite;

import com.recruit.app.dao.UserDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.UserDO;
import com.recruit.app.domain.model.User;
import com.recruit.app.service.UserService;
import com.recruit.app.service.mapper.UserMapper;

public class SQLiteUserService implements UserService {
	private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
	public long addUser(User user) {
		UserDO userDO = UserMapper.convertToDO(user);
		return userDAO.addUser(userDO);
	}

	public User queryById(long id) {
		UserDO userDO = userDAO.queryById(id);
		return UserMapper.convertToModel(userDO);
	}

}
