package com.mn.contactstore.service;

import java.util.List;

import com.mn.contactstore.domain.User;
import com.mn.contactstore.exception.UserBlockedException;

/**
 * @author Md Nazish
 * The interface specifies all business operation for User Entity.
 */
public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;

	public boolean register(User user);
	
	/*
	 * this method handling login operation(authentication) with credential.
	 * if user account is blocked, An exption will be thrown by this method.
	 */
	public User login(String loginName, String password) throws UserBlockedException;
	
	/**
    * Call this method to get list of registered users.
    * @return 
    */
   public List<User> getUserList();
   
   /**
    * This method change the user login status [either active or blocked] for details passed as argument.
    * @param userId
    * @param loginStatus 
    */
   public void changeLoginStatus(Integer userId, Integer loginStatus);
	
}
