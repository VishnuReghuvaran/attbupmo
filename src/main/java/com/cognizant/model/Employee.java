package com.cognizant.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employees")
public class Employee {

	public String empid;
	public String empname;	
	public String attId;
	public boolean nicFormCompliant;
	public boolean ciaFormCompliant;
	public String MngrName;
	public String ciaComplianceDate;
	public String addressLine1;
	public String addressLine2;
	public String nicComplianceDate;		
	public List<Project> prj_assignments;
	public String signature;
	public String designation;
	
	
	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public String getMngrName() {
		return MngrName;
	}

	public void setMngrName(String mngrName) {
		MngrName = mngrName;
	}

	public List<Project> getPrj_assignments() {
		return prj_assignments;
	}

	public void setPrj_assignments(List<Project> prj_assignments) {
		this.prj_assignments = prj_assignments;
	}

	public boolean isNicFormCompliant() {
		return nicFormCompliant;
	}

	public void setNicFormCompliant(boolean nicFormCompliant) {
		this.nicFormCompliant = nicFormCompliant;
	}

	public boolean isCiaFormCompliant() {
		return ciaFormCompliant;
	}

	public void setCiaFormCompliant(boolean ciaFormCompliant) {
		this.ciaFormCompliant = ciaFormCompliant;
	}
	
	

	public String getCiaComplianceDate() {
		return ciaComplianceDate;
	}

	public void setCiaComplianceDate(String ciaComplianceDate) {
		this.ciaComplianceDate = ciaComplianceDate;
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

	public String getNicComplianceDate() {
		return nicComplianceDate;
	}

	public void setNicComplianceDate(String nicComplianceDate) {
		this.nicComplianceDate = nicComplianceDate;
	}


	public String getAttId() {
		return attId;
	}

	public void setAttId(String attId) {
		this.attId = attId;
	}

	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", ndcFormCompliant=" + nicFormCompliant
				+ ", ciaFormCompliant=" + ciaFormCompliant + ", MngrName=" + MngrName +"]";
	}

	
	
}
