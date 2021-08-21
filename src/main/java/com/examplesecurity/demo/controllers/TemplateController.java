package com.examplesecurity.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class TemplateController {

    @GetMapping(path = "login")
    public String getSignIn() {
        return "sign_in";
    }

    @GetMapping(path = "courses")
    public String getCourses() {
        return "courses";
    }
}
