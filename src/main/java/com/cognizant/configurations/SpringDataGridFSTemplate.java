package com.cognizant.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFSDBFile;

@Component
public class SpringDataGridFSTemplate {
	@Bean
	public  MongoDbFactory mongoDbFactory() throws Exception {
		Mongo mongo = new Mongo("localhost");
		String databaseName = "myfiles";
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo,
				databaseName);
		return mongoDbFactory;
	}
	@Bean
	public  GridFsTemplate gridFsTemplate() throws Exception {
		MongoDbFactory dbFactory = mongoDbFactory();
		MongoConverter converter = mongoConverter();
		GridFsTemplate gridFsTemplate = new GridFsTemplate(dbFactory, converter);
		return gridFsTemplate;
	}
	@Bean
	public  MongoConverter mongoConverter() throws Exception {
		MongoMappingContext mappingContext = new MongoMappingContext();
		MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(
				mongoDbFactory(), mappingContext);
		return mappingMongoConverter;
	}
}