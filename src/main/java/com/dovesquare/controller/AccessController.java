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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, Model model,
            BindingResult bindingResult) throws BindException {
        String username = user.getUsername();
        String password = user.getPassword();
        User dbUser = userService.findUserByUsername(username);
        System.out.println(username);
        System.out.println(password);
        if (dbUser.getPassword().equals(user.getPassword())) {
            System.out.println("success");
            Role b = new Role(1);
            User TempUser = new User("kennychung", "kenny100", b);
            TempUser.setEmail("yoyocicada@gmail.com");

            model.addAttribute(user);
            return "account";
        }

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
    public String signup(@Valid User user, Model model,
            BindingResult bindingResult) throws BindException {

        if (bindingResult.hasErrors()) {
            System.out.println("has error");
            return "signup";
        }

        // String username = user.getUsername();
        // String password = user.getPassword();

        if (userService.create(user)) {
            return "signup";
        }
        return "account";
    }
}