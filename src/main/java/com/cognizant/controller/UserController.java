package com.cognizant.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.exception.EmployeeException;
import com.cognizant.model.Employee;
import com.cognizant.model.FilePath;
import com.cognizant.model.User;
import com.cognizant.services.Empinfoservice;
import com.cognizant.services.UserService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private Empinfoservice employeeInfoService;

	Logger LOGGER = LogManager.getLogger(EmpinfoController.class.getName());

	@RequestMapping(value = "api/login", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Employee> login(@RequestBody User user) throws EmployeeException {

		User currentUser = userService.findByUsername(user);
	
		if (currentUser != null) {
			Employee currentEmployee = employeeInfoService.getEmpById(user.getUsername());
			return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
		} else {
			throw new EmployeeException("Employee with empID " + user.getUsername() + " not found.");
		}
	}
	
	@RequestMapping(value = "api/uploadUsers", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json", "application/xml" })
	public Object uploadUsers(@RequestBody FilePath path) throws Exception {

		String status = (String) employeeInfoService.insertUser(path);

		if (status != null && status.length() > 0) {
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} else {
			return null;
		}
	}

}
