package com.PhoneBook.App.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PhoneBook.App.Entity.ContactEntity;

@Repository
public interface Contact_Repo extends JpaRepository<ContactEntity, Serializable> {
	
	
	
	

}
