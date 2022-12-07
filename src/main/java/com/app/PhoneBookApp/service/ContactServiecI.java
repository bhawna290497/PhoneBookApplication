package com.app.PhoneBookApp.service;

import java.util.List;

import com.app.PhoneBookApp.entities.Contact;

public interface ContactServiecI {

	public boolean saveContact(Contact contact);
	List<Contact> getAllContact();
}
