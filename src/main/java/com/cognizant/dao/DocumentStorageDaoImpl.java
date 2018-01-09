package com.cognizant.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.configurations.SpringDataGridFSTemplate;
import com.cognizant.controller.DocumentController;
import com.cognizant.model.CIAFormDetails;
import com.cognizant.model.Employee;
import com.cognizant.model.NDAFormDetails;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@Repository
public class DocumentStorageDaoImpl implements DocumentStorageDao {

	Logger LOGGER = LogManager.getLogger(DocumentStorageDaoImpl.class.getName());

	@Autowired
	SpringDataGridFSTemplate springDataGridFSTemplate;

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public String store(InputStream inputStream, String fileName, String contentType, DBObject metaData)
			throws Exception {
		return this.springDataGridFSTemplate.gridFsTemplate().store(inputStream, fileName, contentType, metaData)
				.getId().toString();
	}

	@Override
	public GridFSDBFile retrive(String fileName) {
		return null;
	}

	@Override
	public GridFSDBFile getById(String id) throws Exception {
		return this.springDataGridFSTemplate.gridFsTemplate().findOne(new Query(Criteria.where("_id").is(id)));
	}

	@Override
	public GridFSDBFile getByFilename(String filename) throws Exception {
		LOGGER.debug("File Name " + filename);
		return this.springDataGridFSTemplate.gridFsTemplate()
				.findOne(new Query(Criteria.where("filename").is(filename)));
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object saveFormDetails(Object fromDetails) {
		mongoOperations.save(fromDetails);
		return fromDetails;
	}

	@Override
	public NDAFormDetails retrieveNDAFormsDetails(String empID) {
		// DBCollection collection =
		// mongoDB.getMongoTemplate().getCollection("Form_Compliance");
		Query query = new Query();
		// if(!"null".equals(id))
		query.addCriteria(Criteria.where("empID").is(empID));
		// if(!"null".equals(empname))
		// whereQuery.put("empname", empname);
		NDAFormDetails formsDetails = mongoOperations.findOne(query, NDAFormDetails.class);
		return formsDetails;

	}

	@Override
	public CIAFormDetails retrieveCIAFormsDetails(String empID) {
		// DBCollection collection =
		// mongoDB.getMongoTemplate().getCollection("Form_Compliance");
		Query query = new Query();
		// if(!"null".equals(id))
		query.addCriteria(Criteria.where("empID").is(empID));
		// if(!"null".equals(empname))
		// whereQuery.put("empname", empname);
		CIAFormDetails formsDetails = mongoOperations.findOne(query, CIAFormDetails.class);
		return formsDetails;
	}

}
