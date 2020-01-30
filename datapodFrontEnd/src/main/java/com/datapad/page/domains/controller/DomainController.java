package com.datapad.page.domains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datapad.form.UserForm;
import com.datapad.page.domains.model.DomainModel;
import com.datapad.page.domains.service.DomainService;

@Controller
public class DomainController {
	
	@Autowired
	private DomainService domainService;
	
	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public String getDomains(Model model) {
	  DomainModel response = domainService.getDomains();
	  model.addAttribute("response", response);
	  model.addAttribute("newDomainModel", new DomainModel());
	  return "domain/domain";
	}
	
	
	@PostMapping("/domain")
	public String addDomain(@ModelAttribute DomainModel domainModel, Model model) {
	   DomainModel response = domainService.addDomain(domainModel);
	   return getDomains(model);
	   
	}

}
