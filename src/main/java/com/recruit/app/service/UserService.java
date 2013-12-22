package com.recruit.app.service;

import com.recruit.app.domain.model.User;

public interface UserService {
	public long addUser(User user);
	public User queryById(long id);
}
