package com.dovesquare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dovesquare.domain.Role;
import com.dovesquare.domain.User;
import com.dovesquare.service.UserService;

@Controller
@RequestMapping
public class AccessController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String showlogin(Model model) {
        Role myRole = new Role(1);
        User myUser = new User();
        myUser.setRole(myRole);
        model.addAttribute(myUser);
        return "login";
    }

    @RequestMapping("/login/failure")
    public String loginFailure(ModelMap model) {
        model.addAttribute("status", "login.failure");
        return "login";
    }

    @RequestMapping("/logout/success")
    public String logoutSuccess(ModelMap model) {
        model.addAttribute("status", "logout.success");
        Role myRole = new Role(1);
        User myUser = new User();
        myUser.setRole(myRole);
        model.addAttribute("user", myUser);
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String showSignup(Model model) {
        Role myRole = new Role(1);
        User myUser = new User();
        myUser.setRole(myRole);
        model.addAttribute(myUser);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid User user, BindingResult bindingResult)
            throws BindException {

        if (bindingResult.hasErrors()) {
            System.out.println("has error");
            return "signup";
        }

        // String username = user.getUsername();
        // String password = user.getPassword();
        Role myRole = new Role(1);
        user.setRole(myRole);
        if (userService.create(user)) {
            return "account";
        }
        return "signup";
    }
}