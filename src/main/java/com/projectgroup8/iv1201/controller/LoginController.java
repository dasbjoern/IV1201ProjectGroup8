package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.Person;


@Controller
public class LoginController {

    @Autowired
    private RecruitmentService recruitmentService;


    @GetMapping("/login")
    public String loginGet(Model model){
        return "login";
    }
    

    @PostMapping(value = "/login")
    public String loginPost(Model model, @RequestParam Map<String, String> loginParam){
        if(loginParam.get("username") != null){
            if(loginParam.get("password") != null){
                Person person = recruitmentService.getPerson((String)loginParam.get("username"));
                model.addAttribute("username", person.getUsername());
                model.addAttribute("password", person.getPassword());

                if(person.login((String)loginParam.get("password"))){
                    return "redirect: /hello";
                }else{
                    return "login";
                }
            }
        }
        return "login";

        /* 
        if(login==true){
            return "redirect: /recruitment";
        }else{
            return "login"
        }
        */
    }
    
}
