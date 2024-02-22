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
import com.projectgroup8.iv1201.model.RecruitmentException;

@Controller
@SessionAttributes({"isLoggedIn", "personId"})
public class ApplicationController {

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
 * Handles get requests to the path /applications and views all applications.
 * @param model 
 * @return If succesful, the applications html page. If not, errorPage html page.
 */
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

/**
 * Handles post requests to the path /applications and presents detailed information
 * about a single application.
 * @param appPersonId ID of person associated with the application
 * @param model
 * @param status New status of the application
 * @param version Version number of the last fetched instance of the application
 * @return html pages depending on the request
 */
@PostMapping("/applications")
	public String editApplication(@RequestParam(name = "appPersonId", required=false) Long appPersonId, Model model, 
									@RequestParam(name = "status", required=false) String status,
									@RequestParam(name = "version", required=false) Long version) throws RecruitmentException{
		
		model.addAttribute("isRecruiter", false);
		if(recruitmentService.getPerson((long)model.getAttribute("personId")).getRoleId() == 1){
			model.addAttribute("isRecruiter", true);
		}

		if(appPersonId == null){
			return "redirect:/";
		}
		if(!isLoggedIn(model)){
			return "redirect:/";
		}
		if(status != null){

			recruitmentService.updateApplicationStatus(status, appPersonId, version);
			
			if((boolean)model.getAttribute("isRecruiter")){
				List<ApplicationListDTO> allApplications = recruitmentService.getAllApplications();
				model.addAttribute("applicationList", allApplications);
				
			}else{
				List<ApplicationListDTO> application = recruitmentService.getApplication((long)model.getAttribute("personId"));
				model.addAttribute("applicationList", application);
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
