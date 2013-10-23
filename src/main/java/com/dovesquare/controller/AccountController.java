package com.dovesquare.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dovesquare.domain.User;
@Controller
@RequestMapping
public class AccountController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@RequestMapping("/account")
	public String viewAccount(Model model) {
	    User a = new User();
	    a.setFullName("kenny chung");
	    a.setEmail("yoyocicada@gmail.com");
		model.addAttribute(a);
		return "account";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String updateAccount(@Valid User user, BindingResult bindingResult) throws BindException{
        System.out.println("updateAccount");  
        String email=user.getEmail();
        System.out.println(email);
        System.out.println(bindingResult);
		if(bindingResult.hasErrors()){
			System.out.println("has error");
        	return "/account";
        }
            
        return "/account";
	}
}