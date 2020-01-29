package com.datapad.page.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DashboardController {
	   @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	   public String index(Model model) {
	      return "dashboard";
	   }

	  
	   @PostMapping("/dashboard/domains")
	   public String getDomains() {
		   return "domain";
	   }

}
