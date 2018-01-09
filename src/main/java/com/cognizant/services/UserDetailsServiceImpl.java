package com.cognizant.services;

public class UserDetailsServiceImpl  {
		
	/*
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userDAO.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}*/

}
