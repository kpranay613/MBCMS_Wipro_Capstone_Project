package com.wipro.medicalbillingsystem.service;

import java.util.List;

import com.wipro.medicalbillingsystem.dto.InsurancePlansDTO;
import com.wipro.medicalbillingsystem.entities.InsurancePlans;

public interface IInsurancePlansService {
	
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto,String companyName);
	
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto);
	 
	public void deleteInsurancePlan(int planId);
	
	public List<InsurancePlansDTO>  getPlanByType(String planType);
	
	public List<InsurancePlans> getAllPlans();
	
	public List<InsurancePlans> getPlansByCompanyName(String companyName);
	
}
