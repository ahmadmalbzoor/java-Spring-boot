package com.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Languages.models.languages;
import com.Languages.services.LanguageService;

@Controller
public class LanguageAPI {
	private final LanguageService languageService;

	public LanguageAPI(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("lang") languages lang) {
		List<languages> langs = languageService.allLanguages();
		model.addAttribute("langs", langs);
		return "/index.jsp";
	}

	@RequestMapping(value = "/languages", method = { RequestMethod.POST })
	public String create(@Valid @ModelAttribute("lang") languages lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/index.jsp";
		} else {
			languageService.createLanguages(lang);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("language") languages lang, BindingResult result, Model model,
			@PathVariable("id") Long id, @RequestParam(value = "name") String name,
			@RequestParam(value = "creator") String creator, @RequestParam(value = "version") Integer version) {

		if (result.hasErrors()) {
			System.out.println("inside eroors ");
			return "edit.jsp";
		} else {
			System.out.println("outside the error if ");
			languageService.updatLanguage(id, name, creator, version);
			return "redirect:/languages";
		}
	}
	

	@RequestMapping(value = "/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.DeleteLang(id);
		return "redirect:/languages";
	}

	@RequestMapping(value = "/edit/{id}")
	public String showlan(@PathVariable("id") Long id, Model model) {
		languages showLanguage = languageService.findLanguages(id);
		System.out.println("inside the method");
		model.addAttribute("showLanguage", showLanguage);
		return "edit.jsp";
	}
	@RequestMapping(value = "/info/{id}")
	public String showinfo(@PathVariable("id") Long id, Model model) {
		languages showinfo = languageService.findLanguages(id);
		System.out.println("inside the method");
		model.addAttribute("showinfo", showinfo);
		return "show.jsp";
	}

}
