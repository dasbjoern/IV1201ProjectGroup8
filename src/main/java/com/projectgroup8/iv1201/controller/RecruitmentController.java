package com.projectgroup8.iv1201.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.RegisterForm;


/**
 * A controller for the recruitment application
 */
@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class RecruitmentController {
	
	@Autowired
	private RecruitmentService recruitmentService;

	@ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(){
        return false;
        }
		

	/**
	 * Handles get requests for home
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}

	/**
	 * Handles get requests for the register applicant page
	 */
	@GetMapping("/registerApplicant")
	public String register(Model model){
		model.addAttribute("registerForm", new RegisterForm());
		return "registerApplicant";
	}

	/**
	 * Handles the post request for request applicant and registers an applicant that has filled in the register form
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
