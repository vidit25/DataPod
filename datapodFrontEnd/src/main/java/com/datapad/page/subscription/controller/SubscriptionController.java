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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datapad.base.models.GenericModel;
import com.datapad.form.SubscriptionForm;
import com.datapad.page.domains.model.DomainModel;
import com.datapad.page.domains.service.DomainService;
import com.datapad.page.subscription.model.SubscriptionModel;
import com.datapad.page.subscription.service.SubscriptionService;
import com.datapad.page.subscriptionType.model.SubscrptionTypeModel;

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

	@Autowired
	private SubscriptionService subscriptionService;

	/**
	 * This method is used load Enquiry Form. 	
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	public String handleSubscription(Model model)
	{
		model.addAttribute("subscriptionForm", new SubscriptionForm());
		DomainModel response = domainService.getAllDomains();
		model.addAttribute("domains", response);
		return "subscription/enquiry";
	}

	
	@RequestMapping(value = "/getSubDomains", method = RequestMethod.GET)
	@ResponseBody
	public DomainModel getSubDomainByDomainId(@RequestParam String domainId) {
		DomainModel response = domainService.getDomainById(domainId);
		return response;
	}
	
	
	@RequestMapping(value = "/list-subscription", method = RequestMethod.GET)
	public String handleSubscriptionList(Model model)
	{
		SubscriptionModel subscriptionModel =  subscriptionService.getSubscriptionByInitiatedStatus();
		model.addAttribute("subscriptions", subscriptionModel);
		return "subscription/list-subscription";
	}
	
	@PostMapping("/activate-subscription")
	public String handleActivateSubscription(@RequestParam Integer id) {
		GenericModel genericModel = subscriptionService.activateSubcription(id);
		return "redirect:/list-subscription";
	}

	/**
	 * This method will subscription type based on domain
	 * @param domainId
	 * @return
	 */
	@RequestMapping(value = "/getSubscriptionType", method = RequestMethod.GET)
	@ResponseBody
	public SubscrptionTypeModel getSubscriptionTypeByDomainId(@RequestParam String domainId) {
		SubscrptionTypeModel response =subscriptionService.getSubscriptionTypeByDomain(domainId);
		return response;
	}

	@PostMapping("/submitEnquiry")
	public String handleCreateSubscription(@ModelAttribute SubscriptionForm subscriptionForm, Model model) {

		GenericModel genericModel = subscriptionService.createSubcription(subscriptionForm);
		LOGGER.info("SUCCESS.." + genericModel.isSuccess());
		return "subscription/enquiry";
	}
}
