package com.datapad.page.domains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	   return "domain/domain";
	}

}
