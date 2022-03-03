package com.contacts.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contacts.app.entity.Person;
import com.contacts.app.repository.contactsRepository;



@SpringBootApplication
public class ContactManagerAppApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ContactManagerAppApplication.class, args);
	}
	@Autowired
	private contactsRepository contactRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Person contact1 = new Person("Ramesh", "Fadatare", "ramesh@gmail.com","9276543678");
		//contactRepository.save(contact1);
	}

}
