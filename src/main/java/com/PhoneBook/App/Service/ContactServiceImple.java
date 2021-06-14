package com.PhoneBook.App.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhoneBook.App.DTO.Contact;
import com.PhoneBook.App.Entity.ContactEntity;
import com.PhoneBook.App.Repository.Contact_Repo;

@Service
public class ContactServiceImple implements ContactService {
	
	@Autowired
	private Contact_Repo contactrepo;

	@Override
	public boolean saveContact(Contact savecon) {
		
		ContactEntity entity=new ContactEntity();
		
		BeanUtils.copyProperties(savecon, entity);
		
		ContactEntity SavedEntity=contactrepo.save(entity);
		
		return SavedEntity.getContactId()!=null ;
	}

	@Override
	public List<Contact> getAllContacts() { 
		
		List<ContactEntity> entites=contactrepo.findAll();
		
		//List<Contact> contacts=new ArrayList<Contact>();
		
		/*
		 * for(ContactEntity entity:entites) { Contact contact=new Contact();
		 * BeanUtils.copyProperties(entity, contact); contacts.add(contact); }
		 */		
		
			List<Contact> contacts=entites.stream().map(entity->{
			
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity,contact);
			return contact;
			}).collect(Collectors.toList());
		
		
		return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) { 
		
	Optional<ContactEntity> findById = contactrepo.findById(cid);
		if(findById.isPresent())
		{
			ContactEntity contactentity=findById.get();
			 
			Contact c=new Contact();
			
			BeanUtils.copyProperties(contactentity,c );
			
			return c ;
			
		}
		
		 
		return null;
	}

	@Override
	public boolean UpdateContact(Contact updatecon) {
		
	
		return false;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		
		contactrepo.deleteById(contactId);
		
		return true	;
	}

}
