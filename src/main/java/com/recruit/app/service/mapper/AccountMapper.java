package com.recruit.app.service.mapper;

import com.recruit.app.db.dataobject.AccountDO;
import com.recruit.app.domain.model.Account;

public class AccountMapper {
	public static AccountDO convertToDO(Account account) {
		if(account == null) {
			return null;
		}
		AccountDO accountDO = new AccountDO();
		accountDO.setEmail(account.getEmail());
		accountDO.setId(account.getId());
		accountDO.setMobilePhone(account.getMobilePhone());
		accountDO.setPassword(account.getPassword());
		accountDO.setUserName(account.getUserName());
		return accountDO;
	}
	
	public static Account convertToModel(AccountDO accountDO) {
		if(accountDO == null) {
			return null;
		}
		Account account = new Account();
		account.setEmail(accountDO.getEmail());
		account.setId(accountDO.getId());
		account.setMobilePhone(accountDO.getMobilePhone());
		account.setPassword(account.getPassword());
		account.setUserName(accountDO.getUserName());
		return account;
	}
}
