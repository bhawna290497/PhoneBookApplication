package com.app.PhoneBookApp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.PhoneBookApp.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
