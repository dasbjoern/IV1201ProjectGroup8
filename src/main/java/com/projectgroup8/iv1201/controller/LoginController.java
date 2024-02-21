package com.projectgroup8.iv1201.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import com.projectgroup8.iv1201.service.RecruitmentService;

import jakarta.validation.Valid;

import com.projectgroup8.iv1201.model.LoginForm;
import com.projectgroup8.iv1201.model.PersonDTO;
import com.projectgroup8.iv1201.model.RegisterForm;

@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class LoginController {
    
    /**
     * Creates isLoggedIn attribute and adds it to the model if it does not exist and returns it otherwise.
     * @param model
     * @return isLoggedIn model and session attribute
     */
    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(Model model){
        if(model.getAttribute("isLoggedIn") == null)
            return false;
        else
            return (boolean)model.getAttribute("isLoggedIn");
        }

    @Autowired
    private RecruitmentService recruitmentService;
    
    /**
     * Redirects to appropriate page if logged in
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String loginGet(Model model){
        
        if(isLoggedIn(model))
            return "redirect:/applications";
        else{    
            // model.addAttribute("loginForm", new LoginForm());
            
            return "redirect:/";
        }
    }
    

    /**
     * Login method, checks username and password entered via the login form and compares it to the database. 
     * Redirects if already logged in.
     * @param loginForm Check contraints for input before calling the database.
     * @param bindingResult Returns errors if wrong input in form.
     * @param model
     * @return redirects if logged in otherwise returns home.
     * @throws NoSuchAlgorithmException Throws error if cryptographic algorithm is not found.
     */
    @PostMapping(value = "/login")
    public String loginPost(@Valid LoginForm loginForm, BindingResult bindingResult, Model model) throws NoSuchAlgorithmException{
        
        if(isLoggedIn(model)){
            return "redirect:/applications";
        }
        if(bindingResult.hasErrors()){
			return "home";
		}
       
                
                // long id = recruitmentService.login((String)loginParam.get("username"), (String)loginParam.get("password"));
                long id = recruitmentService.login(loginForm);
                PersonDTO person;

                if(id != -1 && ((person = recruitmentService.getPerson(id)) != null)){
                    model.addAttribute("isLoggedIn", true);
                    model.addAttribute("personId", person.getPersonId());
                    model.addAttribute("name", person.getName());  
                }
                else
                    model.addAttribute("loginErrorMessage", ErrorHandler.loginFailed);      
                           
        return "redirect:/";
    }

    /**
     * Used to let user logout by setting the isLoggedIn flag to false.
     * @param model
     * @return redirects to home page.
     */
    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("isLoggedIn", false);
        return "redirect:/";
    }
    
}
