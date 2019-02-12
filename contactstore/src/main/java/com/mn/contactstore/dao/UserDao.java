package com.mn.contactstore.dao;

import java.util.List;

import com.mn.contactstore.domain.User;

/**
 * @author Md Nazish
 *
 */
public interface UserDao {

	// Basic CRUD methods
	public boolean addUser(User user);

	public User getUserById(Integer userId);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	public boolean deleteUserById(Integer userId);

	// Business methods
	public List<User> findAll();

	public List<User> findByProperty(String propName, Object propValue);
	
	
}
