package com.ibolit.ibolituser.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityDataRepo extends JpaRepository<SpecialityData, Integer>{

	SpecialityData findBySpecialityName(String specialityName);




}
