package com.projectgroup8.iv1201.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.projectgroup8.iv1201.model.RecruitmentException;

@Controller
@ControllerAdvice
@SessionAttributes({"isLoggedIn", "personId"})
public class ErrorHandler {
    // public static final String loginError = "loginErrorMessage";
    public static final String loginFailed = "Login failed.";

    
    /**
     * Sends an error if no handler is found, page not found.
     * @param model
     * @param e error message
     * @return error message to error page
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noHandlerFound(Model model, Exception e){
        model.addAttribute("errorMessage", "404 Page Not Found.");
        
        //TEMP should not be in view.
        // model.addAttribute("internalError", e);

        return "errorPage";
    }

    
    /**
     * Handles Illegal arguments during registration that cause internal error
     * @param model
     * @param e error message
     * @return returns error message to error page
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String registerException(Model model, Exception e){
        model.addAttribute("errorMessage", "Illegal arguments during registration.");
        
        //TEMP should not be in view.
        // model.addAttribute("internalError", e);

        return "errorPage";
    }
    
    /**
     * Handles generic exceptions
     * @param model
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String myException(Model model, Exception e){
        model.addAttribute("errorMessage", "Internal Server Error. Generic exception");
        
        //TEMP should not be in view.
        model.addAttribute("internalError", e);

        return "errorPage";
    }

    /**
     * Handles exception for missing cryptation algorithm.
     * @param model
     * @param e Error message
     * @return error to error page
     */
    @ExceptionHandler(NoSuchAlgorithmException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String passwordSHAException(Model model, Exception e){
        model.addAttribute("errorMessage", "Internal Server Error. Cryptation algorithm is not available.");
 

        return "errorPage";
    }
    
    /**
     * Catches any SQL exception when communicating with the database.
     * @param model
     * @param e
     * @return error message to error page.
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String dataBaseException(Model model, Exception e){
        model.addAttribute("errorMessage", "Internal Server Error. A problem occured with the database.");
 

        return "errorPage";
    }
    
    /**
     * Handles buisness logic exceptions.
     * @param model
     * @param exceptionMessage
     * @return Error to errorpage
     */
    @ExceptionHandler(RecruitmentException.class)
    @ResponseStatus(HttpStatus.OK)
    public String recruitException(Model model, RecruitmentException exceptionMessage){

        model.addAttribute("errorMessage", exceptionMessage.getMessage());
        
        return "errorPage";
    }
    
    /**
     * Handles runtime exceptions, such as the database loosing connections and out of bounds exceptions
     * @param model
     * @param exceptionMessage
     * @return error message to error page.
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String runTimeException(Model model, RuntimeException exceptionMessage){
        String errorMessage = "Internal Server Error. Runtime Exception";
        if(exceptionMessage.getMessage().contains("EntityManager")){
            errorMessage = "Internal Server Error. Database could not be reached. Try again later.";
        }
        if(exceptionMessage.getMessage().contains("OutOfBounds")){
            errorMessage = "Internal Server Error. Value out of bounds.";
        }
        model.addAttribute("errorMessage", errorMessage);

        //temp for finding errors
        model.addAttribute("internalError", exceptionMessage);
        return "errorPage";
    }

    /**
     * Returns an appropriate error message when database contraints are broken.
     * @param e Error message with info about the contraint.
     * @return returns a String with the appropriate error message.
     */
    public static String parseRegisterException(Exception e){
        String error = "Could not create account.";
        if(e.getMessage().contains("username_unq")){
            error = "Username already exists.";
        }
        if(e.getMessage().contains("pnr_unq")){
            error = "Person number already exists.";
        }
        if(e.getMessage().contains("email_unq")){
            error = "Email already exists.";
        }

        return error;
    }
    
  
}
