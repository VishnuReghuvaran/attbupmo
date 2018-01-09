/**
 * 
 */
package com.cognizant.model;

/**
 * @author 572792
 *
 */
public class Project {
	
	String prjId;
	String prjName;
	int Total_No_of_emp;
	int No_of_Compliance;
	int No_of_Nonvompliance;
	
	
	
	public String getPrjId() {
		return prjId;
	}
	
	public void setPrjId(String prjId) {
		this.prjId = prjId;
		
	}
	
	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public int getTotal_No_of_emp() {
		return Total_No_of_emp;
	}
	public void setTotal_No_of_emp(int total_No_of_emp) {
		Total_No_of_emp = total_No_of_emp;
	}
	public int getNo_of_Compliance() {
		return No_of_Compliance;
	}
	public void setNo_of_Compliance(int no_of_Compliance) {
		No_of_Compliance = no_of_Compliance;
	}
	public int getNo_of_Nonvompliance() {
		return No_of_Nonvompliance;
	}
	public void setNo_of_Nonvompliance(int no_of_Nonvompliance) {
		No_of_Nonvompliance = no_of_Nonvompliance;
	}
	
	
	@Override
	public String toString() {
		return "Project [prjId=" + prjId + ", Total_No_of_emp=" + Total_No_of_emp + ", No_of_Compliance="
				+ No_of_Compliance + ", No_of_Nonvompliance=" + No_of_Nonvompliance + "]";
	}
	
	

}
