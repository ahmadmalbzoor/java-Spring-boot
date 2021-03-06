package com.Licenses.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Licenses.models.Licensess;
import com.Licenses.models.Person;
import com.Licenses.service.LicenseService;
import com.Licenses.service.PersonService;
@Controller
public class controllerAPI {
private final PersonService personService;
private final LicenseService licenseService;
public controllerAPI(PersonService personService,LicenseService licenseService)
{
	this.licenseService=licenseService;
	this.personService=personService;
}
@RequestMapping("/persons/new")

public String index(@ModelAttribute("pers") Person pers)
{
	return "index.jsp";
}
@RequestMapping(value = "/persons/new", method = { RequestMethod.POST })
public String create(@Valid @ModelAttribute("pers") Person pers, BindingResult result) {
	if (result.hasErrors()) {
		return "/index.jsp";
	} else {
		personService.createPerson(pers);
		return "redirect:/persons/new";
	}
}
@RequestMapping("/licenses/new")

public String home(Model model,@ModelAttribute("lice") Licensess lice)
{
	List<Licensess> langs = licenseService.allLicenses();
	model.addAttribute("langs", langs);
	List<Person> pers = personService.allPerson();
	model.addAttribute("pers", pers);

	return "license.jsp";
}
@RequestMapping(value = "/licenses/new", method = { RequestMethod.POST })
public String createlic(@Valid @ModelAttribute("lice") Licensess lice, BindingResult result) {
	if (result.hasErrors()) {
		return "/license.jsp";
	} else {
		licenseService.createLicenses(lice);
		return "redirect:/licenses/new";
	}
}
@RequestMapping(value = "/show/{id}")
public String show(@PathVariable("id") Long id, Model model)
{
	Licensess showLic=licenseService.findLicenses(id);
	model.addAttribute("showLic", showLic);
	Person pers=licenseService.findLicenses(id);
	model.addAttribute("pers", pers);
	return "show.jsp";
	
}
}
