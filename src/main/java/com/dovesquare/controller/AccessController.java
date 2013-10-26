package com.dovesquare.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dovesquare.domain.User;

@Controller
@RequestMapping
public class AccessController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult bindingResult)
			throws BindException {
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println(email);
		System.out.println(password);
		if (bindingResult.hasErrors()) {
			System.out.println("has error");
			return "login";
		}

		return "login";
	}

}