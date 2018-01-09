/**
 * 
 */
package com.cognizant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.PrjInfodao;
import com.cognizant.model.Compliance;



/**
 * @author 572792
 *
 */
@Service
public class PrjInfoserviceImpl implements PrjInfoService {
	
	@Autowired
	PrjInfodao PrjInfodaoimpl;
		
	public Compliance getProjectComplianceDetails(String projectId,String projectName) {
		// TODO Auto-generated method stub		
		return PrjInfodaoimpl.getProjectComplianceDetails(projectId, projectName);
	}
	
}
