package com.ibolit.ibolituser.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDataRepo extends JpaRepository<AppointmentData, Integer>{

	List<AppointmentData> findBySimpleUser(SimpleUser simpleUser);

	
}
