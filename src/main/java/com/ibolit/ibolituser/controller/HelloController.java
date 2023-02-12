package com.ibolit.ibolituser.controller;

import java.util.List;

import com.ibolit.ibolituser.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ibolit.ibolituser.model.AppointmentData;
import com.ibolit.ibolituser.repositories.AppointmentDataRepo;
import com.ibolit.ibolituser.model.SimpleUser;
import com.ibolit.ibolituser.repositories.UserDataRepo;

@RestController
public class HelloController {
	

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

	@Autowired
	private UserDataRepo repository;
	@Autowired
	//private AppointmentDataRepo appointmentDataRepo;
	private AppointmentService appointmentService;

//	@ResponseBody
//	public List<AppointmentData> getAll(){
//		return appointmentService.getAll();
//	}

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
		}else {
			return "there is no such a user in db";
		}

	}
	
	@RequestMapping(value="/getAppointmentData/listAll", method = RequestMethod.GET)
		public String getAll(Model model) {
			List<AppointmentData> appointment = appointmentService.getAll();
			model.addAttribute("appointment", appointment);
			return "parameters/appointmentsList";

			}

	

//	@RequestMapping(value = "/getAppointmentData/listAll", method = RequestMethod.GET)
	//public List<AppointmentData> listAppointment() {
		//List<AppointmentData> listAppointmentData = appointmentDataRepo.findAll();
		//return listAppointmentData;
	//}
}
