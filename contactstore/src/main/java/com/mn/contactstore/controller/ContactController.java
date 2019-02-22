package com.mn.contactstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mn.contactstore.domain.Contact;
import com.mn.contactstore.service.ContactService;

/**
 * @author Md Nazish
 *
 */
@Controller
@RequestMapping("/user")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/add/contact")
	public String addContact(Model model) {
		Contact contact = new Contact();

		model.addAttribute("contactCommand", contact);
		model.addAttribute("title", "Add Contact");
		model.addAttribute("userClickAddContact", true); // checking condition in Master Page (page.jsp)
		return "page"; // addContact Page
	}

	@RequestMapping("/save")
	public String saveOrUpdateContact(@ModelAttribute("contactCommand") Contact contact, Model model, HttpSession session) {
		
		Integer contactId = (Integer) session.getAttribute("attrContactId");
		
		// To Save a contact
		if(contactId == null) {
			try {
				Integer userId = (Integer) session.getAttribute("userId");
				contact.setUserId(userId);// FK : from logged in userId
				
				contactService.save(contact);

				return "redirect:contact/list?action=save"; // contacList Page
			} catch (Exception e) {
				e.printStackTrace();
				// adderror message
				model.addAttribute("error", "Failed To Save Contact! Please enter valid details.");
				model.addAttribute("title", "Add Contact");
				model.addAttribute("userClickAddContact", true); // checking condition in Master Page (page.jsp)
				return "page"; // addContact Page
			}
		}else {
			// To update an existing contact
			try {
				contact.setContactId(contactId); //PK
				// update contact
				contactService.update(contact);

				return "redirect:contact/list?action=update"; // contacList Page
			} catch (Exception e) {
				e.printStackTrace();
				// adderror message
				model.addAttribute("error", "Failed To Update Contact! Please enter valid details.");
				model.addAttribute("title", "Add Contact");
				model.addAttribute("userClickAddContact", true); // checking condition in Master Page (page.jsp)
				return "page"; // addContact Page
			}
		}
		

	}
	
	@RequestMapping("/contact/{contactId}/edit")
	public String editContact(@PathVariable Integer contactId, Model model, HttpSession session) {

		// set session attribute for currect logged in user
		// and to user for update re-filled data by calling saveOrUpdate(-,-,-) method
		session.setAttribute("attrContactId", contactId);
		
		// fetch contact
		Contact contact = contactService.findContactById(contactId);
		
		// call add Contact form with pre-filled values
		model.addAttribute("contactCommand", contact);

		// redirect to addContact Page
		model.addAttribute("title", "Add Contact");
		model.addAttribute("userClickAddContact", true); // chcking condition is Master Page (page.jsp)

		return "page"; // addContact page
	}

	@RequestMapping("/contact/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {

		// delete contact by contactId
		contactService.delete(contactId);

		// redirect to contactList Page with action=message
		return "redirect:list?action=delete"; // contactList page
	}
	
	@RequestMapping("/contact/list")
	public String contactList(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");

		// adding all contacts associated with logged in user by its userId
		model.addAttribute("contacts", contactService.findUserContact(userId));

		model.addAttribute("title", "Contact List");
		model.addAttribute("userClickContactList", true); // chcking condition is Master Page (page.jsp)

		return "page"; // contactList page
	}
}
