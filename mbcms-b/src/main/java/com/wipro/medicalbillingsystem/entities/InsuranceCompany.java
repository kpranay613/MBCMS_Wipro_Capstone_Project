package com.wipro.medicalbillingsystem.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class InsuranceCompany implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "companySeq", initialValue = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companySeq")
	private int companyId;

	@NotNull
	private String companyName;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Letter must be 8")
	private String companyPassword;
	@Email
	private String companyEmail;

	@NotBlank
	private String companyContact;
	private String companyStartYears;
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL)
	private List<InsurancePlans> plans;
	private final   String role="COMPANY";

	public InsuranceCompany() {
		super();

	}

	public InsuranceCompany(int companyId, @NotNull String companyName,
			@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Letter must be 5") String companyPassword,
			@Email String companyEmail, @NotBlank String companyContact, String companyStartYears) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyPassword = companyPassword;
		this.companyEmail = companyEmail;
		this.companyContact = companyContact;
		this.companyStartYears = companyStartYears;
	}

	public String getRole() {
		return role;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyStartYears() {
		return companyStartYears;
	}

	public void setCompanyStartYears(String companyStartYears) {
		this.companyStartYears = companyStartYears;
	}

	@Override
	public String toString() {
		return "InsuranceCompany [companyId=" + companyId + ", companyName=" + companyName + ", companyPassword="
				+ companyPassword + ", companyEmail=" + companyEmail + ", companyContact=" + companyContact
				+ ", companyStartYears=" + companyStartYears + "]";
	}

}
