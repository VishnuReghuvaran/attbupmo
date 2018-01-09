package com.cognizant.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CIAForms")
public class CIAFormDetails {
	
	private String empID;
	
	private String empAttID;

	private String empSignature;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String companyName;
	
	private String date;
	
	private String ssn;
	
	private String fileID;
	
		
	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getSsn() {
		return ssn;
	}

	
	
	public String getEmpAttID() {
		return empAttID;
	}



	public void setEmpAttID(String empAttID) {
		this.empAttID = empAttID;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpSignature() {
		return empSignature;
	}

	public void setEmpSignature(String empSignature) {
		this.empSignature = empSignature;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
