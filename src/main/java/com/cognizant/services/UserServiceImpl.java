package com.cognizant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDAO;
import com.cognizant.model.User;

@Service
public class UserServiceImpl implements UserService {

	// @Autowired
	// private UserRepository userRepository;
	// @Autowired
	// private RoleRepository roleRepository;
	@Autowired
	UserDAO userDAO;

	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 * 
	 * 
	 * @Override public void save(User user) {
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); //
	 * user.setRoles(new HashSet<>(roleRepository.findAll()));
	 * //userRepository.save(user); }
	 */

	@Override
	public User findByUsername(User user) {
		// TODO Auto-generated method stub
		User currentuser = userDAO.findByUsername(user);

		if (currentuser.getPassword() != null && currentuser.getPassword().length() > 0
				&& currentuser.getPassword().equals(user.getPassword())) {
			return currentuser;
		} else {
			return null;
		}
	}

}
