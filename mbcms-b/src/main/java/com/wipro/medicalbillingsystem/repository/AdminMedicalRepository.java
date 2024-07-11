package com.wipro.medicalbillingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.medicalbillingsystem.entities.AdminMedical;

@Repository
public interface AdminMedicalRepository extends JpaRepository<AdminMedical, Integer> {
	
	Optional<AdminMedical> findByAdminName(String adminName);

}
