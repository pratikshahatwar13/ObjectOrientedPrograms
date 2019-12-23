package com.bridgelabzs.controller;

import java.util.List;

import com.bridgelabzs.model.Appointment;
import com.bridgelabzs.model.Doctor;
import com.bridgelabzs.model.Patient;

public interface AddDetails {

	List<Doctor> addDoctor(List<Doctor> doctorList);
	List<Patient> addPatient(List<Patient> patientList);
	List<Appointment> takeAppointment(List<Doctor> doctorList, List<Patient> patientList, List<Appointment> appointmentList);
	<T> void save(List<T> T, String file);
	<T> List<T> read(List<T> T, String file, String model) throws Exception;
}
