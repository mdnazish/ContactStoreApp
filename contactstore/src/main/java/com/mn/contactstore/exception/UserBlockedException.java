package com.mn.contactstore.exception;

/**
 * @author Md Nazish
 *
 */
public class UserBlockedException extends Exception{

	private static final long serialVersionUID = 1L;

	// Default Exception
	public UserBlockedException() {
	}
	
	// Exception with message
	public UserBlockedException(String errorDescrption){
		super(errorDescrption);
	}
	
}
