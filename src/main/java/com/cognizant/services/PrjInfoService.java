/**
 * 
 */
package com.cognizant.services;

import java.util.List;

import com.cognizant.model.Compliance;
import com.cognizant.model.Project;

/**
 * @author 572792
 *
 */
public interface PrjInfoService {
		
	public Compliance getProjectComplianceDetails(String projectId,String projectName);
}
