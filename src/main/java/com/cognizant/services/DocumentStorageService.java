package com.cognizant.services;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import com.cognizant.model.CIAFormDetails;
import com.cognizant.model.NDAFormDetails;
import com.mongodb.gridfs.GridFSDBFile;

public interface DocumentStorageService {
	
	public GridFSDBFile retrieveFormsUsingFilename(String fileName)throws Exception;
	
	public Object saveFormDetails(Object formDetails)throws Exception;
	
	public NDAFormDetails retrieveNDAFormsDetails(String empID);
	
	public CIAFormDetails retrieveCIAFormsDetails(String empID);

}
