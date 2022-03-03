package com.contacts.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.contacts.app.entity.Person;
import com.contacts.app.service.ContactService;




@Controller
public class ContactsController {
	
	private ContactService contactService;
	
	public ContactsController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	// handler method to handle list contacts and return mode and view
	
	@GetMapping("/contacts")
	public String listContacts(Model model) {
		model.addAttribute("contacts",contactService.getAllContacts());
		return "contacts";
	}
	
	@GetMapping("/contacts/new")
	public String createContactForm(Model model) {
		
		// create person object to hold contacts form data
		Person contact = new Person();
		model.addAttribute("contact", contact);
		return "create_contact";
		
	}
	
	@PostMapping("/contacts")
	public String contact(@ModelAttribute("contact") Person contact) {
		contactService.saveContact(contact);
		return "redirect:/contacts";
	}
	
	@GetMapping("/contacts/edit/{id}")
	public String editContactForm(@PathVariable Long id, Model model) {
		model.addAttribute("contact", contactService.getContactById(id));
		return "edit_contact";
	}

	@PostMapping("/contacts/{id}")
	public String updateContactt(@PathVariable Long id,
			@ModelAttribute("contact") Person contact,
			Model model) {
		
		// get contact from database by id
		Person existingContact = contactService.getContactById(id);
		existingContact.setId(id);
		existingContact.setFirstName(contact.getFirstName());
		existingContact.setLastName(contact.getLastName());
		existingContact.setEmail(contact.getEmail());
		existingContact.setPhone(contact.getPhone());
		
		// save updated contact object
		contactService.updateContact(existingContact);
		return "redirect:/contacts";		
	}
	
	// handler method to handle delete contact request
	
	@GetMapping("/contacts/{id}")
	public String deleteContact(@PathVariable Long id) {
		contactService.deletePersonById(id);
		return "redirect:/contacts";
	}
	
}


	
	


