package com.dovesquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovesquare.domain.Account;

@Controller
public class HomeController {
	@RequestMapping({ "/","/home" })
	public String showLogin(Model model) {
		Account account = new Account();
		model.addAttribute(account);
		return "login";
	}
}