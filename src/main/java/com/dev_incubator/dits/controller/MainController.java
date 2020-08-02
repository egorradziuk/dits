package com.dev_incubator.dits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "main"})
    public String showUserForm() {
        return "main";
    }
}
