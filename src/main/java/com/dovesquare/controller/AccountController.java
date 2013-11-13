package com.dovesquare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dovesquare.domain.Role;
import com.dovesquare.domain.User;
import com.dovesquare.service.UserService;

@Controller
@RequestMapping
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping({ "/", "/account" })
    public String viewAccount(Model model) {
        Role b = new Role(1);
        User a = new User("kennychung", "kenny100", b);
        a.setEmail("yoyocicada@gmail.com");

        // userService.create(a);
        model.addAttribute(a);
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String updateAccount(@Valid User user, BindingResult bindingResult)
            throws BindException {
        System.out.println("updateAccount");
        String email = user.getEmail();
        System.out.println(email);
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("has error");
            return "account";
        }

        return "account";
    }
}