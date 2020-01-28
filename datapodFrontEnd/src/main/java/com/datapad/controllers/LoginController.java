package com.datapad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.datapad.form.UserForm;

@Controller
public class LoginController
{
	
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(Model model)
   {
	   model.addAttribute("signinForm", new UserForm());
      return "index";
   }

  
   @PostMapping("/login")
   public String login() {
	   //@TODO to Invoke oauth service
	   return "dashboard";
   }
 
}
