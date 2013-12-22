package com.recruit.app.service.factory;

import com.recruit.app.service.sqlite.SQLiteAccountService;
import com.recruit.app.service.sqlite.SQLiteCompanyService;
import com.recruit.app.service.sqlite.SQLitePositionService;
import com.recruit.app.service.sqlite.SQLiteUserService;

class SQLiteServiceFactory extends ServiceFactory {
	public SQLiteServiceFactory() {
		positionService = new SQLitePositionService();
		companyService = new SQLiteCompanyService();
		accountService = new SQLiteAccountService();
		userService = new SQLiteUserService();
	}
}
