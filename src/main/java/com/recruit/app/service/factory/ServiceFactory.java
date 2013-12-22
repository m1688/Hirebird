package com.recruit.app.service.factory;

import com.recruit.app.service.AccountService;
import com.recruit.app.service.CompanyService;
import com.recruit.app.service.PositionService;
import com.recruit.app.service.UserService;

public abstract class ServiceFactory {
	private static final ServiceFactory instance = new SQLiteServiceFactory();
	protected PositionService positionService;
	protected AccountService accountService;
	protected CompanyService companyService;
	protected UserService userService;
	
	public PositionService getPositionService() {
		return positionService;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}
	
	public CompanyService getCompanyService() {
		return companyService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
}
