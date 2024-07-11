package com.wipro.medicalbillingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.medicalbillingsystem.entities.InsurancePlans;

@Repository
public interface InsurancePlansRepository extends JpaRepository<InsurancePlans, Integer> {

	@Query("select plans from InsurancePlans plans where plans.company.companyName=?1")
	List<InsurancePlans> findByCompanyName(String companyName);
	List<InsurancePlans> findByPlanType(String planType);
}
