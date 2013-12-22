package com.recruit.app.dao;

import com.recruit.app.db.dataobject.AccountDO;

public interface AccountDAO {
	public AccountDO queryByUsername(String username);
	public long addAccount(AccountDO account);
	public AccountDO queryById(long id);
}
