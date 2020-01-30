package com.datapad.page.domains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	  DomainModel response = domainService.getAllDomains();
	  model.addAttribute("response", response);
	  model.addAttribute("newDomainModel", new DomainModel());
	  return "domain/domain";
	}
	
	@RequestMapping(value = "/domainDetails/{id}", method = RequestMethod.GET)
	public String getDomainById(Model model,@PathVariable("id") String id) {
	  DomainModel response = domainService.getDomainById(id);
	  model.addAttribute("response", response);
	  model.addAttribute("newSubDomainModel", new DomainModel());
	  model.addAttribute("domainModel", new DomainModel());
	  return "domain/subDomain";
	}
	
	@PostMapping("/subDomain")
	public String addSubDomain(@ModelAttribute DomainModel domainModel, Model model) {
	   DomainModel response = domainService.addSubDomain(domainModel);
	   return getDomainById(model,String.valueOf(domainModel.getId()));
	}
	
	@PostMapping("/domain")
	public String addDomain(@ModelAttribute DomainModel domainModel, Model model) {
	   DomainModel response = domainService.addDomain(domainModel);
	   return getDomains(model);
	   
	}

}
