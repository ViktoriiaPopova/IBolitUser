package com.ibolit.ibolituser.services;

import com.ibolit.ibolituser.model.AppointmentData;
import com.ibolit.ibolituser.repositories.AppointmentDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentDataRepo appointmentDataRepo;

    public List<AppointmentData> getAll(){
        return appointmentDataRepo.findAll();
    }
}
