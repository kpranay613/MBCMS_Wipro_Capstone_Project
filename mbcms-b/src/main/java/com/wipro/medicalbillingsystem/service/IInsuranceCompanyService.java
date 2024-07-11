

package com.wipro.medicalbillingsystem.service;

import java.util.List;

import com.wipro.medicalbillingsystem.dto.InsuranceCompanyDTO;
import com.wipro.medicalbillingsystem.entities.InsuranceCompany;

public interface IInsuranceCompanyService {
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto);

	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto,int companyId);

	public void deleteCompanyById(int companyId);

	public InsuranceCompanyDTO getCompanyByName(String companyName);

	public List<InsuranceCompany> getAllInsuranceCompanyDetails();
}
