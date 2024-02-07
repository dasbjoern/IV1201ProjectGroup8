package com.projectgroup8.iv1201.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.PersonDTO;

@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class LoginController {
    // private boolean isLoggedIn = false;
    
    // @ModelAttribute("isLoggedIn")
    // public boolean isLoggedIn(){
    //     return false;
    //     }

    @Autowired
    private RecruitmentService recruitmentService;
    
    @GetMapping("/login")
    public String loginGet(Model model){

        if((boolean)model.getAttribute("isLoggedIn"))
            return "redirect:/";
        else    
            return "home";
    }
    

    @PostMapping(value = "/login")
    public String loginPost(Model model, @RequestParam Map<String, String> loginParam){

        if((boolean)model.getAttribute("isLoggedIn")){
            return "home";
        }
        if((loginParam.get("username") != null)){
            if(loginParam.get("password") != null){
                
                long id = recruitmentService.login((String)loginParam.get("username"), (String)loginParam.get("password"));
                PersonDTO person;

                if(id != -1 && ((person = recruitmentService.getPerson(id)) != null)){
                    model.addAttribute("isLoggedIn", true);
                    model.addAttribute("personId", person.getPersonId());
                    model.addAttribute("name", person.getName());  
                }
                else
                    model.addAttribute("loginErrorMessage", ErrorHandler.loginFailed);
            }         
        }
        return "home";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("isLoggedIn", false);
        return "redirect:/";
    }
    
}
