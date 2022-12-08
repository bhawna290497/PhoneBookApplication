package com.app.PhoneBookApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.PhoneBookApp.entities.Contact;
import com.app.PhoneBookApp.exception.ResourceNotFoundException;
import com.app.PhoneBookApp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiecI{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact savecontact = contactRepository.save(contact);
		if(savecontact!=null)
			return true;
		else
			return false;
	}
	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAll = contactRepository.findAll();
		return findAll;
	}
	@Override
	public Contact getContactById(Integer id) {
		Contact contact = this.contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Contact", "Contact id", id));
		return contact;
	}
	

}
