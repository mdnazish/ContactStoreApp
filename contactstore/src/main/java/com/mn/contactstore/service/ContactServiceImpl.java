package com.mn.contactstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mn.contactstore.dao.AbstractBaseDao;
import com.mn.contactstore.dao.ContactDao;
import com.mn.contactstore.domain.Contact;
import com.mn.contactstore.rowmapper.ContactRowMapper;
import com.mn.contactstore.util.StringUtil;

/**
 * @author Md Nazish
 *
 */
@Service("contactService")
public class ContactServiceImpl extends AbstractBaseDao implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Override
	public boolean save(Contact contact) {
		if (contact != null) {
			contactDao.addContact(contact);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(Contact contact) {
		if (contact != null) {
			contactDao.updateContact(contact);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int contactId) {
		contactDao.deleteContactrById(contactId);
		return true;
	}

	@Override
	public boolean deleteAll(Integer[] contactIds) {
		// seperating id's with comma
		String ids = StringUtil.commaSepratedString(contactIds);

		// creating query for delte all contact and passing ids as IN(ids) CLOUSE
		String sqlQuery = "DELETE FROM contact WHERE contactId IN(" + ids + ")";

		// excute query
		getJdbcTemplate().update(sqlQuery);
		return false;
	}

	@Override
	public List<Contact> findUserContact(int userId) {
		return contactDao.findByProperty("user_id", userId);
	}

	@Override
	public List<Contact> serchUserContact(int userId, String txt) {
		String sqlQuery = "SELECT contact_id, user_id, name, phone, email, address, remark FROM contact "
				+ "WHERE userId=? "
				+ "AND (name LIKE '%"+ txt + "%' "
						+ "OR address LIKE '%" + txt + "%' "
						+ "OR phone LIKE '%" + txt + "%' "
						+ "OR email LIKE '%" + txt+"%' "
						+ "OR "+ "remark LIKE '%" + txt + "%')";
		return getJdbcTemplate().query(sqlQuery, new ContactRowMapper(), userId);
	}

}
