package com.ibolit.ibolituser.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDataRepo extends JpaRepository<SimpleUser, Integer>{

	  // mistake ?? SimpleUser findByUsername(String userName);
	  SimpleUser findByPassword(String password);
	 // commented because of optional: SimpleUser findByEmail(String email);
	  Boolean existsByEmail(String email);
	  Boolean existsByPassword(String password);
	//delete ??static List<SimpleUser> listAll() {
		// TODO Auto-generated method stub
		//return null;
	//}
	Boolean existsBySurname(String surname);
	SimpleUser findByUserName(String username);
	Optional<SimpleUser> findByEmail(String email);
}
