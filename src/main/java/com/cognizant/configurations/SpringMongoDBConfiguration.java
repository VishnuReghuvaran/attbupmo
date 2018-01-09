package com.cognizant.configurations;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.cognizant.controller.DocumentController;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoDBConfiguration {

	Logger LOGGER = LogManager.getLogger(DocumentController.class.getName());
	
	public @Bean MongoDbFactory getMongoDbFactory() throws Exception {
		LOGGER.debug("Inside getMongoDbFactory");
		return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "att_compliance_Forms");
	}

	public @Bean MongoTemplate getMongoTemplate() throws Exception {
		LOGGER.debug("Inside getMongoTemplate");
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
		return mongoTemplate;
	}
}
