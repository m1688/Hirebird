package com.recruit.app.service.factory;

import com.recruit.app.service.sqlite.SQLiteAccountService;
import com.recruit.app.service.sqlite.SQLiteCompanyService;
import com.recruit.app.service.sqlite.SQLiteContactService;
import com.recruit.app.service.sqlite.SQLiteEducationService;
import com.recruit.app.service.sqlite.SQLiteJobTargetService;
import com.recruit.app.service.sqlite.SQLitePositionService;
import com.recruit.app.service.sqlite.SQLiteResumeService;
import com.recruit.app.service.sqlite.SQLiteUserService;
import com.recruit.app.service.sqlite.SQLiteWorkExpService;

class SQLiteServiceFactory extends ServiceFactory {
	public SQLiteServiceFactory() {
		positionService = new SQLitePositionService();
		companyService = new SQLiteCompanyService();
		accountService = new SQLiteAccountService();
		userService = new SQLiteUserService();
		educationService = new SQLiteEducationService();
		contactService = new SQLiteContactService();
		jobTargetService = new SQLiteJobTargetService();
		workExpService = new SQLiteWorkExpService();
		resumeService = new SQLiteResumeService();
	}
}
