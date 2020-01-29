package com.datapad.page.login.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datapad.form.UserForm;
import com.datapad.page.login.service.LoginService;

@Controller
public class LoginController
{
	
	@Autowired
	private LoginService loginService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
   /**
    * This method is used load login screen. 	
    * @param model
    * @return
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(Model model)
   {
	   model.addAttribute("signinForm", new UserForm());
      return "index";
   }

   /**
    * This method will login.
    * @param userForm
    * @return
    */
   @PostMapping("/login")
   public String login (@ModelAttribute UserForm userForm, Model model) {
	   
	   if(loginService.doLogin(userForm)) {
		   return "dashboard";
	   }
	   model.addAttribute("signinForm", new UserForm());
	   return "index";
	   
   }

}
