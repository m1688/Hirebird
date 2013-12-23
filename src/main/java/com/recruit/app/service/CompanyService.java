package com.recruit.app.service;

import com.recruit.app.domain.model.Company;

public interface CompanyService {
	public Company queryCompanyById(long companyId);
	public long addCompany(Company company);
}
