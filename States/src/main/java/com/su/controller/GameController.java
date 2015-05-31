package com.su.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class GameController {

	
	
	
	
	@RequestMapping(value="/GuessingGame.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm(){
		ModelAndView model = new ModelAndView("GuessingGame");
		
		return model;
	}
	
	@ModelAttribute
	public void addingStupidAttr(Model model){
		model.addAttribute("headerMessage", "Hot Or Cold!");
	}
	
	@RequestMapping(value="/submitGameForm.html", method = RequestMethod.POST)
	public ModelAndView submitGameForm(@Valid @ModelAttribute("player") Player player, BindingResult result){
		ModelAndView model;
		if(result.hasErrors()){
			 model = new ModelAndView("GuessingGame");
			 return model;
		}
		
		
		model = new ModelAndView("Game");
		model.addObject("player", player);
		return model;
	}
	
	
	
	
}