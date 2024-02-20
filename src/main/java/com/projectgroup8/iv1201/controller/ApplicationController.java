package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.CompetenceInfoDTO;
import com.projectgroup8.iv1201.model.ApplicationDTO;
import com.projectgroup8.iv1201.model.ApplicationListDTO;
import com.projectgroup8.iv1201.model.AvailabilityDTO;
import com.projectgroup8.iv1201.model.Person;

@Controller
public class ApplicationController {
	
	@Autowired
	private RecruitmentService recruitmentService;



@GetMapping("/applications")
	public String viewAllApplications(Model model) {
		
        List<ApplicationListDTO> allApplications = recruitmentService.getAllApplications();
		model.addAttribute("applicationList", allApplications);
			
		return "applications";
	}

@PostMapping("/applications")
	public String editApplication(@RequestParam(name = "applicationToEdit", required=false) String personId, Model model){

		if(personId == null){
			return "redirect:/";
		}
		
        List<CompetenceInfoDTO> competences = recruitmentService.getCompetenceInfoList(Long.parseLong(personId));
		model.addAttribute("competences", competences);
		ArrayList<AvailabilityDTO> availabilityList = recruitmentService.getAvailability(Long.parseLong(personId));
		model.addAttribute("availability", availabilityList);
		return "editapplication";
	}

}
