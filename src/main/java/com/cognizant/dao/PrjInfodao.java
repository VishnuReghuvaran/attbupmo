/**
 * 
 */
package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Compliance;
import com.cognizant.model.Project;

/**
 * @author 572792
 *
 */
public interface PrjInfodao {
	
	public Compliance getProjectComplianceDetails(String projectId, String projectName);
	
}
