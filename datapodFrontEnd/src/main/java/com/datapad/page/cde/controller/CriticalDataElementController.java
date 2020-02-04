/**
 * 
 */
package com.datapad.page.cde.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.datapad.form.FunctionalDataForm;
import com.datapad.page.cde.model.CriticalDataElementModel;
import com.datapad.page.cde.service.CriticalDataElementService;
import com.datapad.page.domains.model.DomainModel;
import com.datapad.page.domains.service.DomainService;

/**
 * @author Data Pod
 *
 */
@Controller
public class CriticalDataElementController {
	
	@Autowired
	private CriticalDataElementService  criticalDataElementService;
	
	@Autowired
	private DomainService domainService;
	
	@GetMapping("/load-functional-data")
	public String loadFunctionalCDE(Model model) {
		model.addAttribute("functionalDataForm", new FunctionalDataForm());
		DomainModel response = domainService.getAllDomains();
		model.addAttribute("domains", response);
		return "cde/cde-functional-data";
		
	}
	
	@PostMapping("/retrieve-functional-data")
	public String retrieveFuncationDataCDE(@ModelAttribute FunctionalDataForm functionalDataForm, Model model) {
		StringBuilder subDomainIds = new StringBuilder();
		Iterator<Integer> iter = functionalDataForm.getSubDomainIds().iterator();
	     while(iter.hasNext())
	     {
	    	 subDomainIds.append(iter.next());
	        if(iter.hasNext()){
	        	subDomainIds.append(",");
	        }
	     }
	     CriticalDataElementModel response = criticalDataElementService.getCriticalDataElementBySubDomain(subDomainIds.toString());
	     model.addAttribute("functionalData", response);
	     model.addAttribute("functionalDataForm", new FunctionalDataForm());
		return "cde/list";
	}

}
