package com.cognizant.services;

import com.cognizant.model.User;

public interface UserService {
//	public void save(User user);

	public User findByUsername(User user);
}
