package com.recruit.app.dao;

import com.recruit.app.db.dataobject.UserDO;

public interface UserDAO {
	public long addUser(UserDO user);
	public UserDO queryById(long id);
}
