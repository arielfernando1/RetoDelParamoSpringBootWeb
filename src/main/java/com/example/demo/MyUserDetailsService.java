package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepo;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.getUserByUsername(username);
		if(user==null) {
			 throw new UsernameNotFoundException("Could not find user");
		}
		// TODO Auto-generated method stub
		return new MyUserDetails(user);
	}

}
