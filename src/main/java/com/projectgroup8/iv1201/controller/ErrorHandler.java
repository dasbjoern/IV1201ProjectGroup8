package com.projectgroup8.iv1201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandler {
    
    @GetMapping("/errornoperson")
    public String ErrorNoPerson(Model model){
        model.addAttribute("error_no_person", "error person not found");
        
        return "redirect: /login";
    }
}
