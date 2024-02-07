package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.validation.Valid;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.Person;
import com.projectgroup8.iv1201.model.PersonDTO;
import com.projectgroup8.iv1201.model.RegisterForm;



@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class RecruitmentController {
	
	@Autowired
	private RecruitmentService recruitmentService;

	@ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(){
        return false;
        }
		

//example code.
@GetMapping("/")
	public String hello(Model model) {
		return "home";
	}

	/**
	 * Redirects to the register page
	 */
	@GetMapping("/registerApplicant")
	public String register(Model model){
		model.addAttribute("registerForm", new RegisterForm());
		return "registerApplicant";
	}

	/**
	 * Registers an applicant that has filled in the register form
	 * @param registerForm	The register form
	 */
	@PostMapping("/registerApplicant")
	public String registerApplicant(@Valid RegisterForm registerForm, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "registerApplicant";
		}
		
		if(recruitmentService.registerApplicant(registerForm))
			model.addAttribute("loginErrorMessage", "Account Created.");
		else
			model.addAttribute("loginErrorMessage", "Could not create account.");

		return "home";
	}


}
