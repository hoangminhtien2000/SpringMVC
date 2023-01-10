package com.checkemail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Home {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

//    private static Pattern pattern;
//    private Matcher matcher;
//
//    public Home() {
//        pattern = Pattern.compile(EMAIL_REGEX);
//    }

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/validate")
    public String user(@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email,EMAIL_REGEX);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "home";
        }
        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String email,String regex) {
        return email.matches(regex);
    }

}
