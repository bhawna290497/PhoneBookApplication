package com.app.PhoneBookApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.PhoneBookApp.entities.Contact;
import com.app.PhoneBookApp.exception.ResourceNotFoundException;
import com.app.PhoneBookApp.props.AppConstant;
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
		Optional<Contact> findById = contactRepository.findById(id);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}
	@Override
	public boolean updateContact(Contact contact) {
		Contact contact2 = contactRepository.save(contact);

		if (contact2 != null) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public boolean deleteContact(Integer id) {
		Optional<Contact> findById = contactRepository.findById(id);
		if(findById.isPresent())
		{
			contactRepository.deleteById(id);
			return true;
		}
		else
			return false;
	}
	@Override
	public boolean deleteConatctSoft(Integer id) {
		Optional<Contact> findById = contactRepository.findById(id);
		if(findById.isPresent())
		{
			Contact contact = findById.get();
			contact.setActiveSwitch(AppConstant.N);
			contactRepository.save(contact);
			return true;
		}
		return false;
	}
	

}
