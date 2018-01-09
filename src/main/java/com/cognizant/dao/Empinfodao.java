package com.cognizant.dao;

import java.util.List;
import java.util.Map;

import com.cognizant.model.Compliance;
import com.cognizant.model.Employee;
import com.cognizant.model.User;

public interface Empinfodao {

	public List<Object> getDetails();

	public Compliance getAllEmployee();
	
	public Employee getEmpById(String id);
	
	public Object updateEmployeeDetails(Map employeeDetailsMap,String formName);
	
	public Object insertEmployee(Employee employee);
	
	public Object insertUser(User user);
	
	public Object updateEmpById(Employee emp);
}
