package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.CompanyDO;
import com.recruit.app.domain.model.Company;

/**
 * CompanyDO &lt;-&gt; Company
 * @author Administrator
 *
 */
public class CompanyMapper {
	public static CompanyDO convertToDO(Company company) {
		if(company == null) {
			return null;
		}
		CompanyDO companyDO = new CompanyDO();
		companyDO.setAddress(company.getAddress());
		companyDO.setId(company.getId());
		companyDO.setIndustry(company.getIndustry());
		companyDO.setName(company.getName());
		companyDO.setScale(company.getScale());
		companyDO.setStructure(company.getStructure());
		return companyDO;
	}
	
	public static Company convertToModel(CompanyDO companyDO) {
		if(companyDO == null) {
			return null;
		}
		Company company = new Company();
		company.setAddress(companyDO.getAddress());
		company.setId(companyDO.getId());
		company.setIndustry(companyDO.getIndustry());
		company.setName(companyDO.getName());
		company.setScale(companyDO.getScale());
		company.setStructure(companyDO.getStructure());
		return company;
	}
}
