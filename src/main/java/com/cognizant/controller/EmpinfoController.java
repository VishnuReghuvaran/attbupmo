package com.cognizant.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.EmployeeException;
import com.cognizant.exception.ErrorResponse;
import com.cognizant.model.CIAFormDetails;
import com.cognizant.model.Compliance;
import com.cognizant.model.Employee;
import com.cognizant.model.FilePath;
import com.cognizant.services.Empinfoservice;
import com.cognizant.util.MigrateEmployeeUtil;
import com.cognizant.util.PdfGenerationUtil;

@RestController
public class EmpinfoController extends BaseController{

	@Autowired
	private Empinfoservice empService;
	
	@Autowired
	MigrateEmployeeUtil migrateEmployeeUtil;

	Logger LOGGER = LogManager.getLogger(EmpinfoController.class.getName());

	public static final String JSON_FILE="employee.txt";
		
	@RequestMapping(value = "api/getAllemployee", method = RequestMethod.GET, headers = "Accept=application/json")
	public Compliance getAllEmployeeDetails(){
		LOGGER.debug("Getting AllEmployeeDetails details");
		Compliance compliance=empService.getAllEmployee();
		return compliance;
	}

	@RequestMapping(value = "api/emp/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Employee>  getEmployee(@PathVariable String id) throws EmployeeException{
		Employee employee = empService.getEmpById(id);
		if(employee!=null){
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else{
			throw new EmployeeException("Employee with empID "+id+" not found.");
		}
	}
	
	@RequestMapping(value = "api/updateEmpoyee", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee emp) throws EmployeeException{
		Employee employee =(Employee) empService.updateEmpById(emp);
		if(employee!=null){
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else{
			throw new EmployeeException("Employee with empID "+emp.getEmpid()+" not found.");
		}
	}
	
	@RequestMapping(value = "api/importEmployees", method = RequestMethod.POST,  consumes = {
	"application/json" }, produces = { "application/json", "application/xml" },headers = "Accept=application/json")
	public Object importEmployee(@RequestBody FilePath path){
		 return migrateEmployeeUtil.importEmployee(path.getPath());
	}

}
