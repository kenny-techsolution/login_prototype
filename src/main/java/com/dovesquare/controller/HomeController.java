package com.dovesquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovesquare.domain.User;

@Controller
public class HomeController {
	@RequestMapping({"/", "/login"})
	public String showLogin(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "login";
	}
}