package com.projectgroup8.iv1201.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectgroup8.iv1201.repository.*;
import com.projectgroup8.iv1201.model.*;

/**
 * The service that accesses the repositories of the Recruitment Database
 */
@Service
@Transactional
public class RecruitmentService {
    
    @Autowired
    private AvailabilityRepository availabilityRepository;
    @Autowired
    private CompetenceProfileRepository competenceProfileRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * Gets a person by username
     * @param username The username
     * @return A <code>Person</code> with the username. <ode>null</code> if no person was found
     */
    public Person getPerson(String username){
        return personRepository.findByUsername(username);
    }

    public Competence getCompetence(String name){
        return competenceRepository.findByName(name);
    }

    public List<CompetenceInfoDTO> getCompetenceInfoList(long personId){
        List<CompetenceProfile> competenceProfileList = competenceProfileRepository.findAllByPersonId(personId);
        ArrayList<CompetenceInfoDTO> infoList = new ArrayList<CompetenceInfoDTO>();
        String competenceType;
        for(int i = 0; i < competenceProfileList.size(); i++){
            competenceType = competenceRepository.findById(competenceProfileList.get(i).getCompetenceId()).getName();
            infoList.add(new CompetenceInfoDTO(competenceProfileList.get(i), competenceType));
        }
        return infoList;
    }

    public ArrayList<AvailabilityDTO> getAvailability(long personId){
        ArrayList<AvailabilityDTO> availabilityDTOList = new ArrayList<AvailabilityDTO>();
        List<Availability> availabilityList = availabilityRepository.findAllByPersonId(personId);
        for(int i = 0; i < availabilityList.size(); i++){
            availabilityDTOList.add((AvailabilityDTO)availabilityList.get(i));
        }
        return availabilityDTOList;
    }

    public Person registerApplicant(RegisterForm registerForm){
        Person personEntity = new Person();

        personEntity.setName(registerForm.getName());
        personEntity.setSurname(registerForm.getSurname());
        personEntity.setPnr(registerForm.getPnr());
        personEntity.setEmail(registerForm.getEmail());
        personEntity.setUsername(registerForm.getUsername());
        personEntity.setPassword(registerForm.getPassword());
        
        Role roleObj = roleRepository.findByName("applicant");
        personEntity.setRoleId(roleObj.getRoleId());

        return personRepository.save(personEntity);
    }

    public List<ApplicationListDTO> getAllApplications(){
        List<Application> appList = applicationRepository.findAll();
        List<Long> personIdList = new ArrayList<>();
        List<ApplicationListDTO> dtoList = new ArrayList<ApplicationListDTO>();
        for(int i = 0; i < appList.size(); i++){
            personIdList.add(appList.get(i).getPersonId());
        }
        List<Person> personList = personRepository.findAllById(personIdList);
        for(int i = 0; i < appList.size(); i++){
            dtoList.add(new ApplicationListDTO(appList.get(i), personList.get(i)));
        }
        return dtoList;
    }

    public ApplicationDTO getApplication(long personId){
        return (ApplicationDTO)applicationRepository.findByPersonId(personId);
    }

}
