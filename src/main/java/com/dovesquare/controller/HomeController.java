package com.dovesquare.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/", "/home"})
	public String showHomepage(Map<String, Object> model) {
		model.put("randomNumbers", (Object) Math.random());
		System.out.println("it works!");
		System.out.println((Object) Math.random());
		return "home";
	}

}