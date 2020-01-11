package com.deloitte.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deloitte.bean.Person;
import com.deloitte.exception.PersonException;
import com.deloitte.service.IPersonService;

@Controller
public class PersonController {
	@Autowired
	IPersonService PersonService;

	List<String> catList = null;
	List<Person> alist;

	@RequestMapping(value = "/addPerson.obj")
	public String redirectToAddPerson(Model model) throws PersonException {
		Person Person = new Person();
		model.addAttribute("clist", catList);
		model.addAttribute("Person", Person);
		return "PersonForm";
	}

	@RequestMapping(value = "/submitPerson.obj")
	public String addPerson(
			@ModelAttribute(value = "Person") @Valid Person Person,
			BindingResult bindingResult, Model model) throws PersonException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("clist", catList);
			return "PersonForm";
		} else {
			int output = PersonService.addPerson(Person);
			model.addAttribute("PersonId", Person.getId());
			if (output == 1) {
				return "successAdd";
			} else {
				return "PersonAdded";
			}
		}
	}

	@RequestMapping(value = "/retreivePerson.obj")
	public String showAllPersons(Model model) throws PersonException {
		alist = PersonService.getPersonList();
		model.addAttribute("elist", alist);
		System.out.println(alist);
		return "showAllPage";
	}

	@RequestMapping(value = "/goHome.obj")
	public String goToHome(Model model) {
		return "index";
	}
	
	@ExceptionHandler(PersonException.class)
	public String handleException(PersonException e){
		e.printStackTrace();
		return "PersonException";
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e){
		e.printStackTrace();
		return "dataException";
	}

}
