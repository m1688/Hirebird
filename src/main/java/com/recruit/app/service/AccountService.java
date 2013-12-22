package com.recruit.app.service;

import com.recruit.app.domain.model.Account;

public interface AccountService {
	public long addAccount(Account account);
	public Account queryAccountById(long id);
	public Account queryAccountByUsername(String username);
}
