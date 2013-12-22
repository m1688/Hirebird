package com.recruit.app.service.sqlite;

import com.recruit.app.dao.AccountDAO;
import com.recruit.app.dao.factory.DAOFactory;
import com.recruit.app.db.dataobject.AccountDO;
import com.recruit.app.domain.model.Account;
import com.recruit.app.service.AccountService;
import com.recruit.app.service.mapper.AccountMapper;

public class SQLiteAccountService implements AccountService {
	private AccountDAO accountDAO = DAOFactory.getInstance().getAccountDAO();
	public long addAccount(Account account) {
		AccountDO accountDO = AccountMapper.convertToDO(account);
		return accountDAO.addAccount(accountDO);
	}

	public Account queryAccountById(long id) {
		AccountDO accountDO = accountDAO.queryById(id);
		return AccountMapper.convertToModel(accountDO);
	}

	public Account queryAccountByUsername(String username) {
		AccountDO accountDO = accountDAO.queryByUsername(username);
		return AccountMapper.convertToModel(accountDO);
	}

}
