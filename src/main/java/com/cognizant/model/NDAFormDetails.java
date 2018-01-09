package com.cognizant.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="NDAForms")
public class NDAFormDetails {
	
	private String empID;
	
	private String empAttID;
		
	private String employeeName;
	
	private String empSignature;
	
	private String companyName;
	
	private String date;
	
	private String fileID;
	
	
	
	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getEmpAttID() {
		return empAttID;
	}

	public void setEmpAttID(String empAttID) {
		this.empAttID = empAttID;
	} 
	
	public String getEmployeeSignature() {
		return empSignature;
	}

	public void setEmployeeSignature(String employeeSignature) {
		this.empSignature = employeeSignature;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
