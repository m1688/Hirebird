package com.recruit.app.dao.factory;

import com.recruit.app.dao.sqlite.SQLiteAccountDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteCompanyDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteContactDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteEducationDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteJobTargetDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteMessageDAOImpl;
import com.recruit.app.dao.sqlite.SQLitePositionDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteResumeDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteUserDAOImpl;
import com.recruit.app.dao.sqlite.SQLiteWorkExpDAOImpl;

class SQLiteDAOFactory extends DAOFactory {
	public SQLiteDAOFactory() {
		companyDAO = new SQLiteCompanyDAOImpl();
		positionDAO = new SQLitePositionDAOImpl();
		userDAO = new SQLiteUserDAOImpl();
		accountDAO = new SQLiteAccountDAOImpl();
		eduDAO = new SQLiteEducationDAOImpl();
		contactDAO = new SQLiteContactDAOImpl();
		jobTargetDAO = new SQLiteJobTargetDAOImpl();
		workExpDAO = new SQLiteWorkExpDAOImpl();
		resumeDAO = new SQLiteResumeDAOImpl();
        messageDAO = new SQLiteMessageDAOImpl();
	}

}
