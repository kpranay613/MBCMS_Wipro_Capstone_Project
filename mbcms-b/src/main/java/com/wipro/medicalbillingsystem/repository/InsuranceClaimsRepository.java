package com.wipro.medicalbillingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.medicalbillingsystem.entities.InsuranceClaims;

@Repository
public interface InsuranceClaimsRepository extends JpaRepository<InsuranceClaims, Long> {

	@Query("SELECT claim FROM InsuranceClaims claim JOIN claim.plans plan JOIN plan.company company WHERE company.companyName = ?1 ")
	public List<InsuranceClaims> getAllClaimByPlanNameandByCompanyName(String companyName);

	@Query("select claim from InsuranceClaims claim where claim.claimStatus=?1")
	public List<InsuranceClaims> getSortedInsuranceclaims(String claimStatus);

	@Query("select claim from InsuranceClaims claim where claim.patient.patientName=?1")
	public List<InsuranceClaims> getClaimByPatientName(String patientName);
}
