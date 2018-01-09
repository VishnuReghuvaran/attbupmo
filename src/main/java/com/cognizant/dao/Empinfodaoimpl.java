package com.cognizant.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cognizant.configurations.SpringMongoDBConfiguration;
import com.cognizant.model.Compliance;
import com.cognizant.model.Employee;
import com.cognizant.model.User;
import com.cognizant.services.Empinfoserviceimpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

@Repository
public class Empinfodaoimpl implements Empinfodao {

	Logger LOGGER = LogManager.getLogger(Empinfoserviceimpl.class.getName());

	@Autowired
	private SpringMongoDBConfiguration mongoDB;
	

	@Autowired
	private MongoOperations mongoOperations;

	
	public List<Object> getDetails() {
		LOGGER.debug("Inside Empinfodaoimpl");
		List<Object> list = new ArrayList<Object>();
		try {
			/*
			 * MongoClient mongo = new MongoClient("localhost", 27017);
			 * System.out.println("Sucessfully connected with database!!!!!!!!"
			 * );
			 * 
			 * @SuppressWarnings("deprecation") DB db = mongo.getDB("database");
			 * System.out.println("Entered in database"); DBCollection
			 * collection = db.getCollection("empinfo");
			 */
			DBCollection collection = mongoDB.getMongoTemplate().getCollection("empinfo");
			DBCursor dbo = collection.find();
			while (dbo.hasNext()) {
				list.add(dbo.next());
				System.out.println(dbo.toString());
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return list;
	}
	
	public Compliance getAllEmployee(){
		
		Compliance compliance;
		int total_No_of_Employees = 0;
		String nicFormCompliance;
		String ciaFormCompliance;
		int compliance_Available = 0;
		int non_Compliance;
		String totalEmployees = null;
		String compliance1 = null;
		
		try {
			DBCollection collection=mongoDB.getMongoTemplate().getCollection("Form_Compliance");
			DBCursor cursor=collection.find();
			total_No_of_Employees=cursor.count();
			LOGGER.debug("total_No_of_Employees" + total_No_of_Employees);
			while(cursor.hasNext()){
				BasicDBObject object = (BasicDBObject) cursor.next();
				nicFormCompliance = (String) object.get("ndaFormCompliant");
				ciaFormCompliance = (String) object.get("ciaFormCompliant");
				
				if (ciaFormCompliance.equals("Y") && nicFormCompliance.equals("Y")) {
					compliance_Available++;
				}
			}
			totalEmployees = String.valueOf(total_No_of_Employees);
			compliance1 = String.valueOf(compliance_Available);
			LOGGER.debug("totalEmployees" + totalEmployees);
			LOGGER.debug("compliance" + compliance1);
				return new Compliance(totalEmployees, compliance1, String.valueOf(total_No_of_Employees-compliance_Available), "Success");
			}
			
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 LOGGER.debug("Error inside empinfo Dao" + e.getStackTrace());
			 return new Compliance("0", "0", "0", "fail");
		}
	}

	public Employee getEmpById(String id) {
		Employee employee = null;
		try {
			// DBCollection collection =
			// mongoDB.getMongoTemplate().getCollection("Form_Compliance");
			Query query = new Query();
			// if(!"null".equals(id))
			query.addCriteria(Criteria.where("empid").is(id));
			// if(!"null".equals(empname))
			// whereQuery.put("empname", empname);
			employee = mongoOperations.findOne(query, Employee.class);
		} catch (Exception e) {
			LOGGER.error("Error inside Employee DAO " + e.getMessage());
		}
		return employee;
	}

	
	public Object updateEmployeeDetails(Map employeeDetailsMap, String formName) {
		DBCollection collection;
		String Status = "Failed";
		try {
			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sm = new SimpleDateFormat(DATE_FORMAT);
			String strDate = sm.format(new Date());
			collection = mongoDB.getMongoTemplate().getCollection("Employees");
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("empid", employeeDetailsMap.get("empId"));
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject(formName, true));
			WriteResult result = collection.update(whereQuery, update);
			if (formName != null && formName.contains("cia")) {
				update.put("$set", new BasicDBObject("ciaFormCompliant", true));
				collection.update(whereQuery, update);
				update.put("$set", new BasicDBObject("ciaComplianceDate", employeeDetailsMap.get("date")));
				collection.update(whereQuery, update);
				update.put("$set", new BasicDBObject("addressLine1",  employeeDetailsMap.get("addressLine1")));
				collection.update(whereQuery, update);
				update.put("$set", new BasicDBObject("addressLine2" , employeeDetailsMap.get("addressLine2")));
				collection.update(whereQuery, update);
				update.put("$set", new BasicDBObject("signature", employeeDetailsMap.get("signature")));
				collection.update(whereQuery, update);
			} else if (formName != null && formName.contains("nda")) {
				update.put("$set", new BasicDBObject("nicFormCompliant", true));
				collection.update(whereQuery, update);
				update.put("$set", new BasicDBObject("nicComplianceDate",  employeeDetailsMap.get("date")));
				collection.update(whereQuery, update);
			}			
			WriteResult result2 = collection.update(whereQuery, update);
			Status = "Success";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("Employee Update Error " + e.getMessage());
		}
		return Status;
	}
	
	
	
	public Object insertEmployee(Employee employee) {
		DBCollection collection;
		String status = "Failed";
		try {
			mongoOperations.insert(employee);
			status="Employee inserted successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("Employee insert Error " + e.getMessage());
		}
		return status;
	}
	
	public Object insertUser(User user) {
		DBCollection collection;
		String status = "Failed";
		try {
			mongoOperations.insert(user);
			status="Employee inserted successfully";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("Employee insert Error " + e.getMessage());
		}
		return status;
	}
	
	public Object updateEmpById(Employee emp){
		//returns only 'name' field
		Query query = new Query();
		query.addCriteria(Criteria.where("empid").is(emp.getEmpid()));
		Update update = new Update();
		update.set("attId", emp.getAttId());
		mongoOperations.updateFirst(query, update, Employee.class);
		Employee employee = mongoOperations.findOne(query, Employee.class);
		return employee;
	}
}
