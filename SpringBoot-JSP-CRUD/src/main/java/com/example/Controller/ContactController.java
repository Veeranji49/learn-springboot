package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Entity.Contact;
import com.example.Service.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService contactService;

	@RequestMapping(value = "/msg")
	@ResponseBody
	public String msg() {
		return "<h1>Welcome to SpringBoot Application</h1>";
	}

	@RequestMapping("/read-contact")
	public String showReadContactPage(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "readcontact";
	}

	@RequestMapping("/create-contact")
	public String showCreateContactPage(Model model) {
		model.addAttribute("command", new Contact());
		return "createcontact";
	}

	@RequestMapping(value = "/create-contact", method = RequestMethod.POST)
	public String createContact(@ModelAttribute("contact") Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/read-contact";
	}

	@RequestMapping(value = "/update-contact/{id}")
	public String showUpdateContactPage(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("command", contactService.findById(id).orElse(null));
		return "updatecontact";
	}

	@RequestMapping(value = "/update-contact/{id}", method = RequestMethod.POST)
	public String updateContact(@PathVariable int id, @ModelAttribute("contact") Contact contact) {
		contactService.updateContact(id, contact);
		return "redirect:/read-contact";
	}

	@RequestMapping(value = "/delete-contact/{id}")
	public String deleteContact(@PathVariable int id) {
		contactService.deleteById(id);
		return "redirect:/read-contact";
	}

}