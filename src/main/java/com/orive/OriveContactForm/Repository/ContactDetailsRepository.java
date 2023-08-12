package com.orive.OriveContactForm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orive.OriveContactForm.Entity.ContactDetails;
@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long>{

}
