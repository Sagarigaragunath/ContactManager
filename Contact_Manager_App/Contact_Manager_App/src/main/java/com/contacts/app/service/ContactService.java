package com.contacts.app.service;

import java.util.List;

import com.contacts.app.entity.Person;

public interface ContactService {
	
	List<Person> getAllContacts();
	
	Person saveContact(Person person);
		
	Person getContactById(Long id);
		
	Person updateContact(Person person);
		
	void deletePersonById(Long id);


}
