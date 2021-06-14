package com.PhoneBook.App.Service;

import java.util.List;

import com.PhoneBook.App.DTO.Contact;


public interface ContactService {
	
	
	public boolean saveContact(Contact savecon);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public boolean UpdateContact(Contact updatecon);
	
	public boolean deleteContact(Integer contactId);
	
	

}

