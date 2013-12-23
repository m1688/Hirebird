package com.recruit.app.service.sqlite;

import com.recruit.app.dao.CompanyDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.CompanyDO;
import com.recruit.app.domain.model.Company;
import com.recruit.app.service.CompanyService;
import com.recruit.app.service.mapper.CompanyMapper;

public class SQLiteCompanyService implements CompanyService {
	private CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
	public Company queryCompanyById(long companyId) {
		CompanyDO companyDO = companyDAO.queryById(companyId);
		return CompanyMapper.convertToModel(companyDO);
	}

	public long addCompany(Company company) {
		CompanyDO companyDO = CompanyMapper.convertToDO(company);
		return companyDAO.addCompany(companyDO);
	}
}
