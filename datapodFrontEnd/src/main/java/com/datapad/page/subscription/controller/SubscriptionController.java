/**
 * 
 */
package com.datapad.page.subscription.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datapad.form.SubscriptionForm;
import com.datapad.page.domains.service.DomainService;

/**
 * @author DataPod
 *
 */
@Controller
public class SubscriptionController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Value("${endpoint.domainURL}")
	public String domainURL;
	
	@Autowired
	private DomainService domainService;
	/**
	    * This method is used load Enquiry Form. 	
	    * @param model
	    * @return
	    */
	   @RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	   public String index(Model model)
	   {
		   model.addAttribute("subscriptionForm", new SubscriptionForm());
		   //DomainModel response = domainService.getDomains();
		  //model.addAttribute("domains", response.getResponse());
	      return "subscription/enquiry";
	   }

}
