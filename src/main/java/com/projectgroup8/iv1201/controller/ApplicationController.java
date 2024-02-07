package com.projectgroup8.iv1201.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.ApplicationDTO;

@Controller
public class ApplicationController {





	@Autowired
	private RecruitmentService recruitmentService;


//example code.
@GetMapping("/applications")
	public String hello(Model model) {
		
        List<ApplicationDTO> allApplications = recruitmentService.getAllApplications();
        //ApplicationDTO testDto = allApplications.get(0);
        //model.addAttribute("statusTest", testDto.getStatus());
		// Person person = recruitmentService.getPerson("JoelleWilkinson");
		// CompetenceDTO competence = recruitmentService.getCompetence("ticket sales");
		// model.addAttribute("comp", competence.getName());
		// model.addAttribute("test", person.getPassword());
			
		return "applications";
	}


}
