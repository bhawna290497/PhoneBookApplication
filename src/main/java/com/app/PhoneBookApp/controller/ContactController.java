package com.app.PhoneBookApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping(value = "/getContact/{id}", produces = "application/json")
	public ResponseEntity<Contact> getContactByID(@PathVariable Integer id)
	{
		Contact byId = contactServiecI.getContactById(id);
		return new ResponseEntity<Contact>(byId,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact) {

		boolean saveContact = contactServiecI.updateContact(contact);

		if (saveContact) {
			String msg = "Contact Updated  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Updated Successfully", HttpStatus.CREATED);

		}

	}
	
	@DeleteMapping(value="/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
		boolean deleteContact = contactServiecI.deleteContact(contactId);
		
		if(deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.CREATED);

		}
	}
	@DeleteMapping(value="/deleteContactsoft/{contactId}")
	public ResponseEntity<String> deleteContactSoft(@PathVariable Integer contactId){
		boolean deleteContact = contactServiecI.deleteConatctSoft(contactId);
		
		if(deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.OK);

		}
		
	}
}
