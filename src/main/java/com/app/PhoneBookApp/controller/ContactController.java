package com.app.PhoneBookApp.controller;

import java.util.List;
import java.util.Map;

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
import com.app.PhoneBookApp.props.ApiProps;
import com.app.PhoneBookApp.props.AppConstant;
import com.app.PhoneBookApp.service.ContactServiecI;

@RestController
public class ContactController {

	@Autowired
	private ContactServiecI contactServiecI;
	
	@Autowired
	private ApiProps apiProps;
	
	@PostMapping(value = "/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		Map<String,String> messages = apiProps.getMessages();
		System.out.println(messages);
		boolean saveContact = contactServiecI.saveContact(contact);
		if(saveContact)
		{			
			return new ResponseEntity<String>(messages.get(AppConstant.SAVE_SUCCESS), HttpStatus.CREATED);
		}
		else
		{
			return new  ResponseEntity<String>(messages.get(AppConstant.SAVE_FAIL), HttpStatus.BAD_REQUEST);
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
		Map<String,String> messages = apiProps.getMessages();
		
		Contact byId = contactServiecI.getContactById(id);
		if(byId!=null)
		{	
			return new ResponseEntity<Contact>(byId,HttpStatus.OK);
		}
		else                                                                                                                                                                                                 
			return new ResponseEntity(messages.get(AppConstant.GET_CONTACT),HttpStatus.BAD_REQUEST);
		}
	
	@PutMapping(value = "/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact) {

		Map<String,String> messages = apiProps.getMessages();
		boolean saveContact = contactServiecI.updateContact(contact);
		if (saveContact) {
			return new ResponseEntity<String>(messages.get(AppConstant.UPDATE_SUCCESS), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(messages.get(AppConstant.UPDATE_FAIL), HttpStatus.CREATED);

		}

	}
	
	@DeleteMapping(value="/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
		
		Map<String,String> messages = apiProps.getMessages();
		boolean deleteContact = contactServiecI.deleteContact(contactId);
		if(deleteContact) {
			return new ResponseEntity<String>(messages.get(AppConstant.DELETE_SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(messages.get(AppConstant.DELETE_FAIL), HttpStatus.OK);

		}
	}
	@DeleteMapping(value="/deleteContactsoft/{contactId}")
	public ResponseEntity<String> deleteContactSoft(@PathVariable Integer contactId){
		Map<String,String> messages = apiProps.getMessages();
		boolean deleteContact = contactServiecI.deleteConatctSoft(contactId);
		if(deleteContact) {
			return new ResponseEntity<String>(messages.get(AppConstant.DELETE_SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(messages.get(AppConstant.DELETE_FAIL), HttpStatus.OK);

		}
		
	}
}
