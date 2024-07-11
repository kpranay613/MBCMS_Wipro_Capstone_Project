package com.wipro.medicalbillingsystem.service;

import java.util.List;

import com.wipro.medicalbillingsystem.dto.InvoiceDetailsDTO;
import com.wipro.medicalbillingsystem.entities.InvoiceDetails;

public interface IInvoiceDetailsService {
	
	public InvoiceDetails generateInvoice(InvoiceDetailsDTO detailsDTO,long patientId);
	
	public List<InvoiceDetails> getAllGeneratedInvoice();
	
	public InvoiceDetails getInvoiceById(int invoiceId);
	
	public List<InvoiceDetails> getAllByPatientName(String patientName);

}
