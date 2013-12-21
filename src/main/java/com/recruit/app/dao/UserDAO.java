package com.recruit.app.dao;

import com.recruit.app.domain.model.User;

public interface UserDAO {
	public long addUser(User user);
	public User queryById(long userId);
}
