package com.example.demo.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceController {

	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler");
		model.addAttribute("name", "Mohit");
		LocalDate date = LocalDate.now();
		System.out.println(date);
		model.addAttribute("date",date);
		return "about";
	}
	
	@GetMapping("/iterator")
	public String iterHandler(Model m) {
		
		List<String> list = List.of("Ankit" , "Mohit","Aditya");
		m.addAttribute("list",list);
		return "iterator";
	}
	
	@GetMapping("/condition")
	public String condHandler(Model m) {
		
		Boolean isActive = false;
		char gender = 'F';
		m.addAttribute("isActive",isActive); 
		m.addAttribute("gender",gender);
		List<Integer> list = List.of(10);

		m.addAttribute("myList", list);
		return "condition";
		
	}
	
	@GetMapping("/fragment")
	public String fragHandler(Model m) {
		
		String title = "Fragment Content Passing";
		String subtitle = "Subtitle content";
		m.addAttribute("title", title);
		m.addAttribute("subtitle", subtitle);
		return "fragment";
		
	}
	
	@GetMapping("/aboutnew")
	public String forNewAbout() {
		return "aboutnew";
	}
}
