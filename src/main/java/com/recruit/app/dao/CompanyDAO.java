package com.recruit.app.dao;

import com.recruit.app.domain.model.Company;

public interface CompanyDAO {
	public long addCompany(Company company);
	public Company queryById(long companyId);
}
