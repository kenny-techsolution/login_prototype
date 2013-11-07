package com.dovesquare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dovesquare.domain.Account;
import com.dovesquare.domain.Role;
import com.dovesquare.domain.User;
import com.dovesquare.service.AccountService;

@Controller
@RequestMapping
public class AccessController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid Account account, Model model,
			BindingResult bindingResult) throws BindException {
		String userid = account.getUserid();
		String password = account.getPassword();
		Account dbAccount = accountService.findAccountByUserId(userid);
		System.out.println(userid);
		System.out.println(password);
		if (dbAccount.getPassword().equals(account.getPassword())) {
			System.out.println("success");
			Role b = new Role(1);
			User user = new User("kennychung", "kenny100", b);
			user.setEmail("yoyocicada@gmail.com");

			model.addAttribute(user);
			return "account";
		}

		return "login";
	}

}