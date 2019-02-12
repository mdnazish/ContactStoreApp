package com.mn.contactstore.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * @author Md Nazish
 *
 */

// Note : Don't add @Repository or @Service or @Component annotation here 

public abstract class AbstractBaseDao extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSourcee(DataSource dataSource) {

		// supply dataSource to parent
		super.setDataSource(dataSource);
	}

}
