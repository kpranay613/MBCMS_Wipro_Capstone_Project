 package com.wipro.medicalbillingsystem.service;

import java.util.List;

import com.wipro.medicalbillingsystem.dto.InsuranceClaimsDTO;
import com.wipro.medicalbillingsystem.entities.InsuranceClaims;

public interface IInsuranceClaimsService {
	
	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO,String patientName,int planId);

	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO,long claimId);

	public List<InsuranceClaims> getClaimByPatientName(String patientName);
 
	public InsuranceClaimsDTO getById(long claimId);
	 
	public List<InsuranceClaims> getSortedInsuranceClaims(String claimStatus);
	
	public List<InsuranceClaims> getAllInsuranceClaims();
	
	public List<InsuranceClaims>  getClaimsByPlanNameAndCompanyName(String companyName);

	

}
