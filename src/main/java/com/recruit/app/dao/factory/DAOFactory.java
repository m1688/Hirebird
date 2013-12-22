package com.recruit.app.dao.factory;

import com.recruit.app.dao.AccountDAO;
import com.recruit.app.dao.CompanyDAO;
import com.recruit.app.dao.PositionDAO;
import com.recruit.app.dao.UserDAO;

public abstract class DAOFactory {
	private static final DAOFactory instance = new SQLiteDAOFactory();
	protected CompanyDAO companyDAO;
	protected PositionDAO positionDAO;
	protected UserDAO userDAO;
	protected AccountDAO accountDAO;
	
	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}
	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}
	public static DAOFactory getInstance() {
		return instance;
	}
}
