package com.app.PhoneBookApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.PhoneBookApp.entities.Contact;
import com.app.PhoneBookApp.service.ContactServiecI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiecI contactServiecI;
	
	@PostMapping(value = "/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		boolean saveContact = contactServiecI.saveContact(contact);
		if(saveContact)
		{
			String m="Contact save successfully";
			return new ResponseEntity<String>(m, HttpStatus.CREATED);
		}
		else
		{
			String m="Contact not saved";
			return new  ResponseEntity<String>(m, HttpStatus.CREATED);
		}
	}
	@GetMapping(value = "/getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> list = contactServiecI.getAllContact();
		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
	}
}
