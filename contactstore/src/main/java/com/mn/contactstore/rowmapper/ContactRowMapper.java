package com.mn.contactstore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mn.contactstore.domain.Contact;

/**
 * @author Md Nazish
 *
 */
public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contact_id"));
		contact.setUserId(rs.getInt("user_id"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setPhone(rs.getString("phone"));
		contact.setAddress(rs.getString("address"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}
	

}
