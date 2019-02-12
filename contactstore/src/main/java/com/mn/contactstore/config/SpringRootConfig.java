package com.mn.contactstore.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * This is for the Business Layer configuration
 * @author Md Nazish
 */

@Configuration
//@ComponentScan(basePackages = {"com.mn.contactstore.dao","com.mn.contactstore.service"})
@ComponentScan(basePackages = "com.mn.contactstore")

public class SpringRootConfig {
	// TODO : Services, DAO, DataSources, Email Sender & other business layer beans

	// Configure DataSource
	@Bean
	public BasicDataSource getDataSource() {
		// create dataSource obj
		BasicDataSource dataSource = new BasicDataSource();
		// set the Basic Properties
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contact_store_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		// set the dbcp2 connection pool properties
		dataSource.setMaxTotal(3); //max connection limit [set -1 for no limit]
		dataSource.setInitialSize(1); // initial connection is 1
		// to test the connection
		dataSource.setTestOnBorrow(true); 
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}
}
