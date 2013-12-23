package com.recruit.app.dao;

import com.recruit.app.db.dataobject.CompanyDO;

public interface CompanyDAO {
	public long addCompany(CompanyDO company);
	public CompanyDO queryById(long companyId);
}
