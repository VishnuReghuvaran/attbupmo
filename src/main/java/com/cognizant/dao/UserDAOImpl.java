package com.cognizant.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.cognizant.configurations.SpringMongoDBConfiguration;
import com.cognizant.model.User;

@Component
public class UserDAOImpl implements UserDAO {

	Logger LOGGER = LogManager.getLogger(PrjInfodaoimpl.class.getName());

	@Autowired
	SpringMongoDBConfiguration mongoDB;

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public User findByUsername(User user) {		
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(user.getUsername()));
			user = mongoOperations.findOne(query, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
