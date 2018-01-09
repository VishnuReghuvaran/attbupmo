package com.cognizant.services;

import java.util.List;
import java.util.Map;

import com.cognizant.model.Compliance;
import com.cognizant.model.Employee;
import com.cognizant.model.FilePath;
import com.cognizant.model.User;

public interface Empinfoservice {

	public List<Object> getDetails();

	public Compliance getAllEmployee();
	
	public Employee getEmpById(String id);
	
	public Object updateEmpById(Employee emp);
	
	public Object insertUser(FilePath path);
	
	public Object updateEmployeeDetails(Map employeeDetailsMap,String FormName);
	
}
