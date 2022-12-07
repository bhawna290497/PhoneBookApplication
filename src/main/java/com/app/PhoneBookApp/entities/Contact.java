package com.app.PhoneBookApp.entities;

import java.time.LocalDate;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="CONTACT_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CONTCACT_ID")
	private Integer contactId;
	@Column(name ="CONTCACT_NAME")
	private String contactName;
	@Column(name ="CONTCACT_NUMBER")
	private String contactNumber;
	@Column(name ="CONTCACT_EMAIL")
	private String contactEmail;
	@Column(name ="CONTCACT_ACTIVE_SWITCH")
	private Character activeSwitch;
	@Column(name ="CONTCACT_CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name ="CONTCACT_UPDATED_DATE", insertable = false)
	@CreationTimestamp
	private LocalDate upateDate;
	
	
}
