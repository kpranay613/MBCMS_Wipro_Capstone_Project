package com.wipro.medicalbillingsystem.service;

import java.util.List;

import com.wipro.medicalbillingsystem.dto.HealthcareProviderDTO;
import com.wipro.medicalbillingsystem.entities.HealthcareProvider;

public interface IHealthcareProviderService {

	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto);
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto);
	public void deleteProvider(int providerId);
	
	public List<HealthcareProvider> getAllHealthcareProviders();
	public HealthcareProviderDTO getProviderById(int providerId);

	
}
