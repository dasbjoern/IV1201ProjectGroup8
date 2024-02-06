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
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.Person;

@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class LoginController {
    // private boolean isLoggedIn = false;
    
    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(){
        return false;
        }

    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping("/login")
    public String loginGet(Model model){
        if((boolean)model.getAttribute("isLoggedIn"))
            return "hello";
        else    
            return "login";
    }
    

    @PostMapping(value = "/login")
    public String loginPost(Model model, @RequestParam Map<String, String> loginParam){

        if((boolean)model.getAttribute("isLoggedIn")){
            return "hello";
        }
        if(loginParam.get("username") != null){
            if(loginParam.get("password") != null){
                Person person = recruitmentService.getPerson((String)loginParam.get("username"));
                if(person.login((String)loginParam.get("password"))){

                    model.addAttribute("isLoggedIn", true);
                    model.addAttribute("personId", person.getPersonId());
                    // isLoggedIn = true;
                    return "hello";
                }else{
                    return "login";
                }
            }
        }
        return "login";
    }
    
}
