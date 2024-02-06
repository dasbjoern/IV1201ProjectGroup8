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
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.Person;



@Controller
@SessionAttributes("personId")
public class RecruitmentController {
	
	@Autowired
	private RecruitmentService recruitmentService;

	// @ModelAttribute("personId")
    // public int isLoggedIn(){
    //     return 0;
    //     }
		

//example code.
@GetMapping("/")
	public String hello(Model model) {

		Person person = recruitmentService.getPerson("JoelleWilkinson");
		CompetenceDTO competence = recruitmentService.getCompetence("ticket sales");
		model.addAttribute("comp", competence.getName());
		model.addAttribute("test", person.getPassword());

		if(model.getAttribute("personId") == null){
			model.addAttribute("personId", 0);
		}
			
		return "hello";
	}


}
