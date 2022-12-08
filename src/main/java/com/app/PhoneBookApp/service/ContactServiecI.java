package com.app.PhoneBookApp.service;

import java.util.List;

import com.app.PhoneBookApp.entities.Contact;

public interface ContactServiecI {

	public boolean saveContact(Contact contact);
	List<Contact> getAllContact();
	Contact getContactById(Integer id);
	boolean updateContact(Contact contact);
	boolean deleteContact(Integer id);
}
