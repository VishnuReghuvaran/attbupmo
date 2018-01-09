/**
 * 
 */
package com.cognizant.model;

/**
 * @author 572792
 *
 */
public class Compliance {

	public String totalNoOfemployees;
	public String complianceAvailable;
	public String nonCompliance;
	public String projectFound;
	
	public String status;
	
	
	
	public Compliance(String totalNoOfemployees, String complianceAvailable, String nonCompliance, String status) {
		super();
		this.totalNoOfemployees = totalNoOfemployees;
		this.complianceAvailable = complianceAvailable;
		this.nonCompliance = nonCompliance;
		this.status = status;
	}
	
	public String getProjectFound() {
		return projectFound;
	}


	public void setProjectFound(String projectFound) {
		this.projectFound = projectFound;
	}
	
	public String getTotalNoOfemployees() {
		return totalNoOfemployees;
	}
	public void setTotalNoOfemployees(String totalNoOfemployees) {
		this.totalNoOfemployees = totalNoOfemployees;
	}
	public String getComplianceAvailable() {
		return complianceAvailable;
	}
	public void setComplianceAvailable(String complianceAvailable) {
		this.complianceAvailable = complianceAvailable;
	}
	public String getNonCompliance() {
		return nonCompliance;
	}
	public void setNonCompliance(String nonCompliance) {
		this.nonCompliance = nonCompliance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
