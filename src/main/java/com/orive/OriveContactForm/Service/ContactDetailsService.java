package com.orive.OriveContactForm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orive.OriveContactForm.Entity.ContactDetails;
import com.orive.OriveContactForm.Exception.ResourceNotFoundException;
import com.orive.OriveContactForm.Repository.ContactDetailsRepository;

@Service
public class ContactDetailsService {

	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	
	
	public void saveContactDetails(ContactDetails contactDetails)
	{
		 contactDetailsRepository.save(contactDetails);
	}
	
	public List<ContactDetails> getContactAllDetails()
	{
		return contactDetailsRepository.findAll();
	}
	
	public ContactDetails getContactById(Long contactId)
	{
		ContactDetails contactDetails=contactDetailsRepository.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact with the given id is not found"+contactId));
		return contactDetails;
	}
}
