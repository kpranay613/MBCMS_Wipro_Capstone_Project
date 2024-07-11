package com.wipro.medicalbillingsystem.service;

import java.util.List;

/*
@Author :  Hema Sree 
Modified Date : 04-11-2023
Description : Interface of  IPatientsService performing the following operations
*/
import com.wipro.medicalbillingsystem.dto.PatientsDTO;
import com.wipro.medicalbillingsystem.entities.Patients;

public interface IPatientsService {
	
	public Patients addPatients(PatientsDTO patientsdto);
	public Patients updatepatients(PatientsDTO patientsdto);
	public void deletePatients(long patientId);
	public PatientsDTO getPatientByName(String patientName);
	public List<Patients> getAllPatients();

}
