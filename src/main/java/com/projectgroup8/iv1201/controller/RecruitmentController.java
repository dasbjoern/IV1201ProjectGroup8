package com.projectgroup8.iv1201.controller;

import jakarta.validation.Valid;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.LoginForm;
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
    public boolean isLoggedIn(Model model){
        if(model.getAttribute("isLoggedIn") == null)
            return false;
        else
            return (boolean)model.getAttribute("isLoggedIn");
        }
		

	/**
	 * Handles get requests for home
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model) {
		if(isLoggedIn(model)){
			return "redirect:/applications";
		}
		else{
			model.addAttribute("loginForm", new LoginForm());
			return "home";
		}
	}

	/**
	 * Handles get requests for the register applicant page
	 */
	@GetMapping("/registerApplicant")
	public String getRegisterForm(Model model){
		if(isLoggedIn(model)){
			return "redirect:/";
		}
		model.addAttribute("registerForm", new RegisterForm());
		return "registerApplicant";
	}

	/**
	 * Handles the post request for request applicant and registers an applicant that has filled in the register form
	 * Insipred by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/presentation/acct/AcctController.java
	 * @param registerForm	The register form
	 */
	@PostMapping("/registerApplicant")
	public String registerApplicant(@Valid RegisterForm registerForm, BindingResult bindingResult, Model model) throws NoSuchAlgorithmException {
		if(isLoggedIn(model)){
			return "redirect:/";
		}

		if(bindingResult.hasErrors()){
			return "registerApplicant";
		}
		try{
		if(recruitmentService.registerApplicant(registerForm)){
			model.addAttribute("loginErrorMessage", "Account Created.");
			model.addAttribute("isLoggedIn", true);
		}
		else
			model.addAttribute("loginErrorMessage", "Could not create account.");

		return "home";
		
		}catch(org.springframework.dao.DataIntegrityViolationException e){
			model.addAttribute("loginErrorMessage", ErrorHandler.parseRegisterException(e));
			model.addAttribute("loginForm", new LoginForm());

			return "home";
		}
	}


	

}
