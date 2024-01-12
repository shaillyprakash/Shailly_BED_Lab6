package com.gl.collegefest.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.collegefest.dto.UserRegistrationDto;
import com.gl.collegefest.entity.User;

public interface UserService {
	public User save(UserRegistrationDto registrationDto);

	<CustomeUserDetails> CustomeUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
