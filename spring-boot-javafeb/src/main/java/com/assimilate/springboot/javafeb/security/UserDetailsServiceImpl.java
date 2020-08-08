package com.assimilate.springboot.javafeb.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assimilate.springboot.javafeb.dao.UserRepository;
import com.assimilate.springboot.javafeb.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Executing loadUserByUserna for user : " + username);

		User user = userRepository.findByUserName(username);
		System.out.println("User fetched from db : " + user);
		UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUserName());
		userBuilder.authorities(Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
		userBuilder.password(user.getPassword());
		UserDetails userDetails = userBuilder.build();
		return userDetails;
	}

}
