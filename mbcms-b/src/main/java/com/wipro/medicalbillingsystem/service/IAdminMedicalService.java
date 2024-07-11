package com.wipro.medicalbillingsystem.service;

import com.wipro.medicalbillingsystem.dto.AdminMedicalDTO;
import com.wipro.medicalbillingsystem.entities.AdminMedical;

public interface IAdminMedicalService {
	public AdminMedical insertNewAdmin(AdminMedicalDTO adminDTO);
	public AdminMedical updateAdmin(AdminMedicalDTO adminDTO,int adminId);
	

}
