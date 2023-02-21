package com.ibolit.ibolituser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibolit.ibolituser.model.SimpleUser;
import com.ibolit.ibolituser.model.UserDataRepo;

@Service
public class AuthenticationService {
	
	@Autowired
	private  UserDataRepo repository;
	private PasswordEncoder passwordEncoder;
	
	public AuthenticationResponse reqister(RegisterRequest request) {
	//	var user =SimpleUser.builder()
	//			.name(request.ge)
		return null;
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		return null;
	}
}
