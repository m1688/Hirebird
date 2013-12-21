package com.recruit.app.dao.factory;

import com.recruit.app.dao.sqlite.SQLiteCompanyDAOImpl;
import com.recruit.app.dao.sqlite.SQLitePositionDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteUserDAOImpl;

class SQLiteDAOFactory extends DAOFactory {
	public SQLiteDAOFactory() {
		companyDAO = new SQLiteCompanyDAOImpl();
		positionDAO = new SQLitePositionDAOImpl();
		userDAO = new SQLiteUserDAOImpl();
	}

}
