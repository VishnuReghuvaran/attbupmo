package com.cognizant.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.Empinfodao;
import com.cognizant.model.Compliance;
import com.cognizant.model.Employee;
import com.cognizant.model.FilePath;
import com.cognizant.model.User;
import com.cognizant.util.MigrateEmployeeUtil;

@Service
public class Empinfoserviceimpl implements Empinfoservice {

	Logger LOGGER = LogManager.getLogger(Empinfoserviceimpl.class.getName());

	@Autowired
	Empinfodao Empinfodaoimpl;
	
	@Autowired
	MigrateEmployeeUtil migrateEmployeeUtil;

	public List<Object> getDetails() {
		LOGGER.debug("Geeting employee details inside Empinfoserviceimpl");
		return Empinfodaoimpl.getDetails();
	}

	public Employee getEmpById(String id) {
		return Empinfodaoimpl.getEmpById(id);

	}

	public Compliance getAllEmployee() {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		return Empinfodaoimpl.getAllEmployee();
	}

	public Object updateEmployeeDetails(Map employeeDetailsMap, String formName) {
		// TODO Auto-generated method stub
		if ("CIA".equals(formName)) {
			return Empinfodaoimpl.updateEmployeeDetails(employeeDetailsMap, "ciaFormCompliant");
		} else if ("NIC".equals(formName)) {
			return Empinfodaoimpl.updateEmployeeDetails(employeeDetailsMap, "ndaFormCompliant");
		} else {
			return "Failed";
		}
	}

	@Override
	public Object updateEmpById(Employee emp) {
	return Empinfodaoimpl.updateEmpById(emp);
	}

	@Override
	public Object insertUser(FilePath path) {
		migrateEmployeeUtil.createUser(path.getPath());
		return "Success";
	}
	
	

}
