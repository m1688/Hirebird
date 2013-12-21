package com.recruit.app.dao.factory;

import com.recruit.app.dao.CompanyDAO;
import com.recruit.app.dao.PositionDAO;
import com.recruit.app.dao.UserDAO;

public abstract class DAOFactory {
	private static final DAOFactory instance = new SQLiteDAOFactory();
	protected CompanyDAO companyDAO;
	protected PositionDAO positionDAO;
	protected UserDAO userDAO;
	
	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}
	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public static DAOFactory getInstance() {
		return instance;
	}
}
