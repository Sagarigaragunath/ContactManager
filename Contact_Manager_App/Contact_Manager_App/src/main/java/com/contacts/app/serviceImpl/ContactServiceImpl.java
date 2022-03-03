package com.contacts.app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contacts.app.entity.Person;
import com.contacts.app.repository.contactsRepository;
import com.contacts.app.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
private contactsRepository contactRepository;
	
	public ContactServiceImpl(contactsRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public List<Person> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Person saveContact(Person person) {
		// TODO Auto-generated method stub
		return contactRepository.save(person);
	}

	@Override
	public Person getContactById(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).get();
	}

	@Override
	public Person updateContact(Person person) {
		// TODO Auto-generated method stub
		return contactRepository.save(person);
	}

	@Override
	public void deletePersonById(Long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
		
	}


}
