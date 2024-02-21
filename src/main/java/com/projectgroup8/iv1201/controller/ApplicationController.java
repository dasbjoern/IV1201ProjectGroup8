package com.projectgroup8.iv1201.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projectgroup8.iv1201.service.RecruitmentService;
import com.projectgroup8.iv1201.model.CompetenceDTO;
import com.projectgroup8.iv1201.model.CompetenceInfoDTO;
import com.projectgroup8.iv1201.model.ApplicationDTO;
import com.projectgroup8.iv1201.model.ApplicationListDTO;
import com.projectgroup8.iv1201.model.AvailabilityDTO;
import com.projectgroup8.iv1201.model.Person;
import com.projectgroup8.iv1201.model.PersonDTO;

@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class ApplicationController {

	@ModelAttribute("isLoggedIn")
    public boolean isLoggedIn(Model model){
        if(model.getAttribute("isLoggedIn") == null)
            return false;
        else
            return (boolean)model.getAttribute("isLoggedIn");
        }



	@Autowired
	private RecruitmentService recruitmentService;



@GetMapping("/applications")
	public String viewAllApplications(Model model) {
		if(!isLoggedIn(model)){
			return "redirect:/";
		}
		if(model.getAttribute("personId") != null){
			long personId = (long)model.getAttribute("personId");
			PersonDTO person = recruitmentService.getPerson(personId);
			
			if(person.getRoleId() == 1){
				List<ApplicationListDTO> allApplications = recruitmentService.getAllApplications();
				model.addAttribute("applicationList", allApplications);
			}
			else{
				List<ApplicationListDTO> applicationList = recruitmentService.getApplication(personId);
				model.addAttribute("applicationList", applicationList);
			}
			return "applications";
		}else{
			return "errorPage";
		}
	}

@PostMapping("/applications")
	public String editApplication(@RequestParam(name = "appPersonId", required=false) Long appPersonId, Model model, 
									@RequestParam(name = "status", required=false) String status,
									@RequestParam(name = "version", required=false) Long version){

		if(appPersonId == null){
			return "redirect:/";
		}
		if(!isLoggedIn(model)){
			return "redirect:/";
		}
		if(status != null){
			try{
				recruitmentService.updateApplicationStatus(status, appPersonId, version);
			}
			catch(Exception e){
				/********
				 * TODO: HANDLE	
				 */
				e.printStackTrace();
			}

			
			if(recruitmentService.getPerson((long)model.getAttribute("personId")).getRoleId() == 1){
				List<ApplicationListDTO> allApplications = recruitmentService.getAllApplications();
				model.addAttribute("applicationList", allApplications);
			}
			
			return "applications";
		}
        
		ArrayList<ArrayList<?>> combinedList = recruitmentService.getCompetenceAndAvailability(appPersonId);
		ArrayList<CompetenceInfoDTO> competences = (ArrayList<CompetenceInfoDTO>)combinedList.get(0);
		ArrayList<AvailabilityDTO> availabilityList = (ArrayList<AvailabilityDTO>)combinedList.get(1);
		model.addAttribute("competences", competences);
		model.addAttribute("availability", availabilityList);
		model.addAttribute("appPersonId", appPersonId);
		model.addAttribute("version", version);
		

		return "editapplication";
	}

}
