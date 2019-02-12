package com.mn.contactstore.dao;

import java.util.List;

import com.mn.contactstore.domain.Contact;

/**
 * @author Md Nazish
 *
 */
public interface ContactDao {

	// Basic CRUD methods
	public boolean addContact(Contact contact);

	public Contact getContactById(Integer contactId);

	public boolean updateContact(Contact contact);

	public boolean deleteContact(Contact contact);

	public boolean deleteContactrById(Integer contactId);

	// Business methods
	public List<Contact> findAll();

	public List<Contact> findByProperty(String propName, Object propValue);
}
