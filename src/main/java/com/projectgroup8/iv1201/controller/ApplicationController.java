package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.util.List;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.ApplicationDTO;
import com.projectgroup8.iv1201.model.Person;

@Controller
public class ApplicationController {
	
	@Autowired
	private RecruitmentService recruitmentService;


//example code.
@GetMapping("/applications")
	public String hello(Model model) {
		
        List<ApplicationDTO> allApplications = recruitmentService.getAllApplications();
        ApplicationDTO testDto = allApplications.get(0);
        model.addAttribute("statusTest", testDto.getStatus());
		// Person person = recruitmentService.getPerson("JoelleWilkinson");
		// CompetenceDTO competence = recruitmentService.getCompetence("ticket sales");
		// model.addAttribute("comp", competence.getName());
		// model.addAttribute("test", person.getPassword());
			
		return "applications";
	}


}
