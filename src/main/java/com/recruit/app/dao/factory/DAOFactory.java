package com.recruit.app.dao.factory;

import com.recruit.app.dao.AccountDAO;
import com.recruit.app.dao.CompanyDAO;
import com.recruit.app.dao.ContactDAO;
import com.recruit.app.dao.EducationDAO;
import com.recruit.app.dao.JobTargetDAO;
import com.recruit.app.dao.PositionDAO;
import com.recruit.app.dao.ResumeDAO;
import com.recruit.app.dao.UserDAO;
import com.recruit.app.dao.WorkExpDAO;

public abstract class DAOFactory {
	private static final DAOFactory instance = new SQLiteDAOFactory();
	protected CompanyDAO companyDAO;
	protected PositionDAO positionDAO;
	protected UserDAO userDAO;
	protected AccountDAO accountDAO;
	protected EducationDAO eduDAO;
	protected ContactDAO contactDAO;
	protected JobTargetDAO jobTargetDAO;
	protected WorkExpDAO workExpDAO;
	protected ResumeDAO resumeDAO;
	
	public ContactDAO getContactDAO() {
		return contactDAO;
	}
	public JobTargetDAO getJobTargetDAO() {
		return jobTargetDAO;
	}
	public WorkExpDAO getWorkExpDAO() {
		return workExpDAO;
	}
	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}
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
	public EducationDAO getEducationDAO() {
		return eduDAO;
	}
	public static DAOFactory getInstance() {
		return instance;
	}
}
