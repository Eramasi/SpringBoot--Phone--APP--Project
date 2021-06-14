package com.PhoneBook.App.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PhoneBook.App.DTO.Contact;
import com.PhoneBook.App.Entity.ContactEntity;
import com.PhoneBook.App.Service.ContactService;

@Controller
public class ContactInfoController {
	
	 
	@Autowired
	private ContactService contactservice;
	
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(ContactInfoController.class);
	
	@GetMapping(value= {"/","/addContact"})
	public String LoadForm(Model model)
	{
		Contact c=new Contact();
		
		model.addAttribute("contact", c);
		
		return "contactInfo";
	}
	
	
	@PostMapping(value="/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes attribues)
	{ 
		
		boolean isSaved = contactservice.saveContact(c);
		
		
		if(isSaved)
		{
			attribues.addFlashAttribute("succmsg","Contact Saved" );   
		}
		else
		{
			attribues.addFlashAttribute("errorMsg", "Failed to Save Contact");
		}
		
		logger.info(" Contact Saved Successfully "  + c);
		
		return "redirect:/contactsaved";
	}
	
	@GetMapping(value="/contactsaved")
	public String ContactSaved(Model model)
	{
		logger.info("ContactSaved() method called ");
		
		model.addAttribute("contact", new Contact());
		
		return "contactInfo"; 
	}
	
	@GetMapping("/viewContacts")
	public String handleViewContactsLink(Model model)
	{
 		List<Contact> contactsList=contactservice.getAllContacts();
		
		model.addAttribute("contacts", contactsList);
		
		return "viewContacts";
	}
	
}
