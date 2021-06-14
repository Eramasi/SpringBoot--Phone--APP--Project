package com.PhoneBook.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PhoneBook.App.DTO.Contact;
import com.PhoneBook.App.Service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactservice;
	
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model)
	{
		Contact c = contactservice.getContactById(contactId);
		
		model.addAttribute("contact",c);
		
		
			
		return "contactInfo";
	}
	
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model)
	{
		
		boolean Isdeleted = contactservice.deleteContact(contactId);
		if(Isdeleted)
		{
			return "redirect:/viewContacts" ;
		}
		 
		
		
		
		return "viewContacts";
	}

}
