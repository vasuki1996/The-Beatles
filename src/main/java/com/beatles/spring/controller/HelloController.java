package com.beatles.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



	@Controller
	public class HelloController {

		@GetMapping("/hello")
		public String hello(Model model) {

			model.addAttribute("name", "John Doe");

			return "welcome";
		}
		
		@GetMapping("/hibernate")
		public void hiber(Model model) {
			
	}
	}

