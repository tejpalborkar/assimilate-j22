package com.assimilate.springboot.javafeb.controllers;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	// Each controller method returns the view.
	
	// View class
	// Model
	// ModelAndView class
	
	
	@RequestMapping(value = "/api/helloWorld")
	public ModelAndView helloWorld() {
		System.out.println("Executing helloworld method.");
		ModelAndView modelAndView = new ModelAndView("helloWorld");
		return modelAndView;
	}


	@RequestMapping(value = "/message")
	public ModelAndView message() {
		System.out.println("Executing helloworld method.");
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("user", "Salman");
		return modelAndView;
	}
	
}
