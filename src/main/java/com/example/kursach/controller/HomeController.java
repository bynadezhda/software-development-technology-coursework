package com.example.kursach.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage() {
        return "user";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "main";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/all_resume",method = RequestMethod.GET)
    public String allPage() {
        return "all";
    }

    @RequestMapping(value = "/addResume",method = RequestMethod.GET)
    public String addResume() {
        return "addResume";
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view() {
        return "view";
    }
}
