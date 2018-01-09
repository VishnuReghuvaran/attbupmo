package com.cognizant.dao;

import com.cognizant.model.User;

public interface UserDAO {
	
	public User findByUsername(User user);
}
