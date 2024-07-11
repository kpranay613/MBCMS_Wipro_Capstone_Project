package com.wipro.medicalbillingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.medicalbillingsystem.dto.InvoiceDetailsDTO;
import com.wipro.medicalbillingsystem.entities.InvoiceDetails;
import com.wipro.medicalbillingsystem.service.IInvoiceDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/invoicedetails")
public class InvoiceDetailsRestController {

	@Autowired
	private IInvoiceDetailsService service;
	
	@PostMapping("/add/newinvoice/{patientId}")
	@PreAuthorize("hasAuthority('PROVIDER')")
	public InvoiceDetails generateNewInvoice(@RequestBody InvoiceDetailsDTO detailsDTO,@PathVariable long patientId)
	{
		return service.generateInvoice(detailsDTO,patientId);
	}
	
	@GetMapping("/getinvoicebyid/{invoiceId}")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public InvoiceDetails getInvoiceDetailsById(@PathVariable int invoiceId )
	{
		return service.getInvoiceById(invoiceId);
	}
	
	
	@GetMapping("/invoicebypatientname/{patientName}")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public List<InvoiceDetails> getInvoiceDetailsByPatientName(@PathVariable String patientName )
	{
		return service.getAllByPatientName(patientName);
	}
	
	
	@GetMapping("/getallinvoices")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InvoiceDetails> getAllInvoiceDetails()
	{
		return service.getAllGeneratedInvoice();
	}
}

