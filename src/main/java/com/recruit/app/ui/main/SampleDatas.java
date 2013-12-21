package com.recruit.app.ui.main;

import java.util.Date;

import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.domain.model.Account;
import com.recruit.app.domain.model.Company;
import com.recruit.app.domain.model.PositionModel;
import com.recruit.app.domain.model.User;


public class SampleDatas {
	private static final long DAY = 24L * 60 * 60 * 1000;
	public static void init() {
		addCompany();
		addUsers();
		addPosition();
	}
	
	private static void addUsers() {
		for(int i = 1; i < 100; i++) {
			User user = new User();
			Account account = new Account();
			account.setId(i);
			user.setAccount(account);
			user.setBirthday(new Date(System.currentTimeMillis() - 30 * 365 * DAY));
			user.setCreateDate(new Date(System.currentTimeMillis() - i * DAY));
			user.setDegree("学士学位" + i);
			user.setEnglishLevel("英语六级" + i);
			user.setIdNum("240937198203031224301" + (i % 10));
			user.setIdType("身份证");
			user.setMajor("计算机开学与技术");
			user.setModifyDate(new Date());
			user.setName("王重阳" + i);
			user.setSex(1);
			user.setWorkingYear(i % 12);
			DAOFactory.getInstance().getUserDAO().addUser(user);
		}
	}
	
	public static void addPosition() {
		for(int i = 1; i < 10; i++) {
			PositionModel position = new PositionModel();
			Company company = new Company();
			company.setId(i);
			position.setCompany(company);
			position.setDetail("职位详情" + i);
			position.setFunction("职位职能" + i);
			position.setLocation("杭州滨江" + i);
			position.setLowestDegree("高中");
			position.setPostDate(new Date(System.currentTimeMillis() - i * DAY));
			User user = new User();
			user.setId(i);
			position.setPublisher(user);
			position.setQuantity(i);
			position.setSalary("" + (10000 + i%5000));
			position.setSkill("Java");
			position.setWorkYear(i % 13);
			DAOFactory.getInstance().getPositionDAO().addPosition(position);
		}
	}
	
	public static void addCompany() {
		for(int i = 1; i < 100; i++) {
			Company company = new Company();
			company.setAddress("杭州滨江" + i);
			company.setId(i);
			company.setIndustry("IT技术" + i);
			company.setName(i + "有限公司");
			company.setScale("私企");
			company.setStructure(i + "人以上");
			DAOFactory.getInstance().getCompanyDAO().addCompany(company);
		}
	}
}
