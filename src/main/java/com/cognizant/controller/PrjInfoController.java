/**
 * 
 */
package com.cognizant.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ProjectException;
import com.cognizant.model.Compliance;
import com.cognizant.model.Project;
import com.cognizant.services.PrjInfoserviceImpl;

/**
 * @author 572792
 *
 */

@RestController
public class PrjInfoController extends BaseController{
		
	@Autowired
	PrjInfoserviceImpl prjservice;
		
	Logger LOGGER = LogManager.getLogger(PrjInfoController.class.getName());
	
	@RequestMapping(value = "api/project", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Compliance> getProjectDetails(@RequestBody Project project) throws ProjectException{
		LOGGER.debug("Getting employee and project details");
		Compliance compliance=prjservice.getProjectComplianceDetails(project.getPrjId(),project.getPrjName());
		if(compliance!=null && !"0".equals(compliance.getTotalNoOfemployees())){
			return new ResponseEntity<Compliance>(compliance, HttpStatus.OK);
		}else{
			throw new ProjectException("Project with Project id "+project.getPrjId()+" not found.");
		}
	}

}
