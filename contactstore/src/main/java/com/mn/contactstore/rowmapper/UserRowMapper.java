package com.mn.contactstore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mn.contactstore.domain.User;

/**
 * @author Md Nazish
 *
 */
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// create User obj & bind it's values from rs
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setLoginName(rs.getString("login_name"));
		user.setAddress(rs.getString("address"));
		user.setRole(rs.getInt("role"));
		user.setLoginStatus(rs.getInt("login_status"));
		
		return user;
	}

}
