package com.wipro.medicalbillingsystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.medicalbillingsystem.entities.HealthcareProvider;

@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Integer> {

	Optional<HealthcareProvider> findByProviderName(String companyName);
}
