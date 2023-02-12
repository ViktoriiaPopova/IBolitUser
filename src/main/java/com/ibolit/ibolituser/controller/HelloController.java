package com.ibolit.ibolituser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibolit.ibolituser.model.AppointmentData;
import com.ibolit.ibolituser.model.AppointmentDataRepo;
import com.ibolit.ibolituser.model.SimpleUser;
import com.ibolit.ibolituser.model.UserDataRepo;

@RestController
public class HelloController {
	

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

	@Autowired
	private UserDataRepo repository;
	@Autowired
	private AppointmentDataRepo appointmentDataRepo;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public SimpleUser saveData(SimpleUser user) {
		return repository.save(user);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getUserData(SimpleUser user) {
		System.out.println("ok");
		final Boolean userEmailExists = repository.existsByEmail(user.getEmail());
		final Boolean userPasswordExists = repository.existsByPassword(user.getPassword());
		if (userEmailExists && userPasswordExists) {
			return "user exists";
		} else {
			return "there is no such a user in db";
		}

	}
	
	@RequestMapping(value="/getAppointmentData/listAll", method = RequestMethod.GET)
		public String getAll(Model model) {
			List<AppointmentData> appointments = appointmentDataRepo.findAll();
			model.addAttribute("appointment", appointments);
			return "parameters/appointmentsList";
				
			}
		
	

//	@RequestMapping(value = "/getAppointmentData/listAll", method = RequestMethod.GET)
	//public List<AppointmentData> listAppointment() {
		//List<AppointmentData> listAppointmentData = appointmentDataRepo.findAll();
		//return listAppointmentData;
	//}
}
