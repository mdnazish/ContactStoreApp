package com.mn.contactstore.service;

import java.util.List;

import com.mn.contactstore.domain.Contact;

/*
 * The interface specifies all business operation for Contact Entity.
 * @author Md Nazish
 */
public interface ContactService {
    public boolean save(Contact contact);
    public boolean update(Contact contact);
    public boolean delete(int contactId);
    public boolean deleteAll(Integer[] contactIds);
    
     //This method returns all User Contact (User who is logged in). 
    public List<Contact> findUserContact(int userId);
    
     /* This method search contact for user(by userId) based on given free-text-criteria (txt)
     * @param userId User (who is logged in)
     * @param txt criteria used to search - free text search criteria
     * @return 
     */
    public List<Contact> serchUserContact(int userId, String txt);    
}
