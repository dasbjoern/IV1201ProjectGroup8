package com.projectgroup8.iv1201.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
// @SessionAttributes({"isLoggedIn", "personId"})
public class ErrorHandler {
    public static final String loginError = "loginErrorMessage";
    public static final String loginFailed = "Login failed.";
    // public static final String noUsername = "Please enter a username.";
    // public static final String noPassword = "Please enter a password.";

    @GetMapping("/ErrorNoPerson")
    public String ErrorNoPerson(Model model){
        model.addAttribute("errorMessage", "Error person cound not be found.");
        
        return "errorPage";
    }

    
    /**
     * Sends an error if no handler is found, page not found.
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noHandlerFound(Model model, Exception e){
        model.addAttribute("errorMessage", "404 Page Not Found.");
        
        //TEMP should not be in view.
        model.addAttribute("internalError", e);

        return "errorPage";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String registerException(Model model, Exception e){
        model.addAttribute("errorMessage", "Illegal arguments during registration.");
        
        //TEMP should not be in view.
        model.addAttribute("internalError", e);

        return "errorPage";
    }
    
    public class myException extends Exception { 
        public myException(String errorMessage) {
            super(errorMessage);
        }
    }
}
