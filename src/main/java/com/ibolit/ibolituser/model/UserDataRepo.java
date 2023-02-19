package com.ibolit.ibolituser.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDataRepo extends JpaRepository<SimpleUser, Integer>{

	  // mistake ?? SimpleUser findByUsername(String userName);
	  SimpleUser findByPassword(String password);
	  SimpleUser findByEmail(String email);
	  Boolean existsByEmail(String email);
	  Boolean existsByPassword(String password);
	static List<SimpleUser> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
