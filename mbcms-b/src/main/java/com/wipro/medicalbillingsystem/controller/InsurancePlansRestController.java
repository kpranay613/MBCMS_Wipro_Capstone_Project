package com.wipro.medicalbillingsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.medicalbillingsystem.dto.InsurancePlansDTO;
import com.wipro.medicalbillingsystem.entities.InsurancePlans;
import com.wipro.medicalbillingsystem.service.IInsurancePlansService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/insuranceplans")
public class InsurancePlansRestController {

	Logger logger=LoggerFactory.getLogger(InsuranceCompanyRestController.class);

	@Autowired
	private IInsurancePlansService service;


	@PostMapping("/add/plan/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsurancePlans addNewPlan(@RequestBody InsurancePlansDTO plansdto,@PathVariable String companyName) {
		return service.addInsurancePlan(plansdto,companyName);
	}

	@DeleteMapping("/delete/plan/{planId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public void deletePlans(@PathVariable int planId) {
		service.deleteInsurancePlan(planId);
		logger.info("Insurance plan with id "+planId+" is deleted!!!");
		
	}

	@GetMapping("/getplanbytype/{planType}")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public List<InsurancePlansDTO> getByPlanType(@PathVariable String planType) {
		List<InsurancePlansDTO> planDTO = service.getPlanByType(planType);
//		if (planDTO.getPlanType() == null) {
//			throw new PlanNotFoundException(HttpStatus.NO_CONTENT,
//					"There is no plan with Type " + planType + " ! Kindly Add it");
//		}
		return planDTO;
	}

	@GetMapping("/getallplans")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public List<InsurancePlans> getAllPlanDetails() {
		return service.getAllPlans();
	}
	
	
	@GetMapping("/getallplansbycompanyname/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public List<InsurancePlans> getAllPlansByCompanyName(@PathVariable String companyName)
	{
		return service.getPlansByCompanyName(companyName);
	}

}
