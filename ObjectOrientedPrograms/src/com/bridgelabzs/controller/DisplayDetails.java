package com.bridgelabzs.controller;

import java.util.List;

import com.bridgelabzs.model.Appointment;
import com.bridgelabzs.model.Doctor;
import com.bridgelabzs.model.Patient;

public interface DisplayDetails {

	void displayDoctor(List<Doctor> doctorList);
	void displayPatient(List<Patient> patientList);
	void displayAppointment(List<Appointment> appointmentList);
	void displayPopularDoctor(List<Doctor> doctorList);
	void displayPopularSpecialization(List<Doctor> doctorList);
}
