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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgroup8.iv1201.service.RecruitmentService;

import com.projectgroup8.iv1201.model.Person;

@Controller
public class RecruitmentController {

	// @Autowired
	// private DataSource dataSource;
	private RecruitmentService recruitmentService;


//example code.
@GetMapping("/")
	public String hello(Model model) {
		/* 
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("ProjectPU");
        EntityManager entityM = entityFactory.createEntityManager();
        Query queryName = entityM.createNamedQuery("Competence.findname");
        queryName.setFirstResult(0);
		queryName.setMaxResults(1);
		String name = (String)queryName.getSingleResult();
        entityM.close();
        entityFactory.close();*/
		Person person = recruitmentService.getPerson("JoelleWilkinson");
		
		model.addAttribute("test", person.getPassword());
			
		return "hello";
	}


}
