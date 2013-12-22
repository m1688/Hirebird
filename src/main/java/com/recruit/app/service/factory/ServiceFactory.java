package com.recruit.app.service.factory;

import com.recruit.app.service.AccountService;
import com.recruit.app.service.CompanyService;
import com.recruit.app.service.ContactService;
import com.recruit.app.service.EducationService;
import com.recruit.app.service.JobTargetService;
import com.recruit.app.service.PositionService;
import com.recruit.app.service.ResumeService;
import com.recruit.app.service.UserService;
import com.recruit.app.service.WorkExpService;

public abstract class ServiceFactory {
	private static final ServiceFactory instance = new SQLiteServiceFactory();
	protected PositionService positionService;
	protected AccountService accountService;
	protected CompanyService companyService;
	protected UserService userService;
	protected EducationService educationService;
	protected ContactService contactService;
	protected JobTargetService jobTargetService;
	protected WorkExpService workExpService;
	protected ResumeService resumeService;
	
	public ContactService getContactService() {
		return contactService;
	}
	
	public JobTargetService getJobTargetService() {
		return jobTargetService;
	}
	
	public WorkExpService getWorkExpService() {
		return workExpService;
	}
	
	public ResumeService getResumeService() {
		return resumeService;
	}
	
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
	
	public EducationService getEducationService() {
		return educationService;
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
}
