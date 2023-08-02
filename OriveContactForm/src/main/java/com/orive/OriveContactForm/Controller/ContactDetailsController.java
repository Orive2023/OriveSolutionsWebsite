package com.orive.OriveContactForm.Controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.orive.OriveContactForm.Entity.ContactDetails;
import com.orive.OriveContactForm.Service.ContactDetailsService;




@Controller
public class ContactDetailsController {

	@Autowired
	private ContactDetailsService contactDetailsService;
	
	@GetMapping("/")
    public String getContactForm() {
        return "index";
    }

    @GetMapping("/html/contact.html")
    public String getForm(Model model) {
        ContactDetails contactDetails = new ContactDetails();
        model.addAttribute("contactDetails", contactDetails);
        return "contact";
    }
    
    @GetMapping("/contact")
    public String getFormData(Model model) {
        ContactDetails contactDetails = new ContactDetails();
        model.addAttribute("contactDetails", contactDetails);
        return "contact";
    }

    @PostMapping("/contact-create")
    public String saveContactDetails(@Valid @ModelAttribute("contactDetails") ContactDetails contactDetails,BindingResult bindingResult ) {
        
        if(bindingResult.hasErrors())
        {
        	return "contact";
        }
        contactDetailsService.saveContactDetails(contactDetails);
        return "registercontact";
    }



    @GetMapping("/display-contacts")
    public String displayContacts(Model model) {
        List<ContactDetails> contactDetailsList = contactDetailsService.getContactAllDetails();
        model.addAttribute("contactDetailsList", contactDetailsList);
        return "adminside";
    }

	
}
