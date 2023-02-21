package com.ibolit.ibolituser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ibolit.ibolituser.model.AppointmentData;
import com.ibolit.ibolituser.model.AppointmentDataRepo;
import com.ibolit.ibolituser.model.SimpleUser;
import com.ibolit.ibolituser.model.SpecialityData;
import com.ibolit.ibolituser.model.SpecialityDataRepo;
import com.ibolit.ibolituser.model.UserDataRepo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

	@Autowired
	private UserDataRepo userRepository;
	@Autowired
	private AppointmentDataRepo appointmentRepository;
	@Autowired
	private SpecialityDataRepo specialityRepository;
	
	//Registration happens here
	@RequestMapping(value = "/ProfileUser", method = RequestMethod.POST)
	public RedirectView saveData(SimpleUser user) {	
		//Not allow potential user to register with an email or surname that is already exist in db
		Boolean userEmail = userRepository.existsByEmail(user.getEmail());
		Boolean userSurname = userRepository.existsBySurname(user.getSurname());
		if(userEmail || userSurname) {
			System.out.println("user with this email alredy exists");
		}else {
			userRepository.save(user);		
			//Redirect to user profile
			 return new RedirectView("ProfileUser.html");
		}
		 return new RedirectView("RegistrationForm.html");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RedirectView getUserData(SimpleUser user) {
		System.out.println(user);
		//final Boolean userPasswordExists = userRepository.existsByPassword(user.getPassword());
		//before security:
		//SimpleUser existingUser = userRepository.findByEmail(user.getEmail());
		Optional<SimpleUser> existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser.isPresent()) {
			return new RedirectView("ProfileUser.html?userId=" + existingUser.get().getIdUser());
		} else {
			return  new RedirectView("login.html");
		}
	}
	

	@RequestMapping(value = "/getAppointmentData/listAll/{userId}", method = RequestMethod.GET)
	public List<AppointmentData> listAll(@PathVariable Integer userId) {
		SimpleUser simpleUser = userRepository.findById(userId).get();
		List<AppointmentData> appointments = appointmentRepository.findBySimpleUser(simpleUser);
		return appointments;
	}

	@RequestMapping(value = "/makeAppointment/{userId}", method = RequestMethod.POST)
	public RedirectView makeAppointment(@PathVariable Integer userId, AppointmentData appointment) {
		SimpleUser user = userRepository.findById(userId).get();
		appointment.setSimpleUser(user);
		appointmentRepository.save(appointment);
		return new RedirectView("../ProfileUser.html");
	}
//Speciality Operations to display on home.html page
//	@RequestMapping(value="/searchSpecialist/searchSpecialist/{searchValue}",method = RequestMethod.GET)
//	public SpecialityData searchSpecialist(@PathVariable String searchValue){
//		SpecialityData searchSpecialist = specialityRepository.findByspecialityName(searchValue);
//		if (searchSpecialist!=null) {
//			System.out.println("There is such a specialist at out clinic!");
//		}else {
//			System.out.println("There is no such a specialist at our clinic!");
//		}
	//	return searchSpecialist;
//	}
	@RequestMapping(value="/searchSpecialist/searchSpecialist/{searchValue}",method = RequestMethod.GET)
	ResponseEntity<String> response(@PathVariable String searchValue) {
		SpecialityData searchSpecialist = specialityRepository.findBySpecialityName(searchValue.trim().toLowerCase());
		System.out.println(searchValue);

		if(searchSpecialist !=null) {
			return new ResponseEntity<String>(

					"There is such a specialist in our clinic, please make sure you logged on page to make an appointment.", new HttpHeaders(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(
					"We are sorry, but there is NO such a specialist in our clinic!", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
}
