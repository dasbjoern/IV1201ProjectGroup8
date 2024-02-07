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
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/application/BankService.java
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
    public PersonDTO getPerson(long id){
        return new Person(personRepository.findByPersonId(id));
    }
    
    /**
     * Gets a competence row from the name
     * @param name The competence name
     * @return A DTO of the competence
     */
    public CompetenceDTO getCompetence(String name){
        return competenceRepository.findByName(name);
    }

    /**
     * Logs in a user
     * @param username the username
     * @param password the password
     * @return The person id if the username and password is correct, otherwise -1.
     */
    public long login(String username, String password){
        Person person = personRepository.findByUsername(username);
        if(person != null)
            return person.login(password);
        return -1;
    }

    /**
     * Registers a new applicant user
     * @param registerForm The form containing the information of the applicant
     * @return <code>true</code> if the user was successfully registered, otherwise <code>false</code>
     */
    public boolean registerApplicant(RegisterForm registerForm) throws IllegalArgumentException {
        Person personEntity = new Person();

        personEntity.setName(registerForm.getName());
        personEntity.setSurname(registerForm.getSurname());
        personEntity.setPnr(registerForm.getPnr());
        personEntity.setEmail(registerForm.getEmail());
        personEntity.setUsername(registerForm.getUsername());
        personEntity.setPassword(registerForm.getPassword());
        
        Role roleObj = roleRepository.findByName("applicant");
        personEntity.setRoleId(roleObj.getRoleId());
        
        Person registeredPerson = personRepository.save(personEntity);
        
        return (registeredPerson.getPersonId() > 0);
       
    }

    /**
     * Fetches all rows of the application table in the database. The Application
     * objects which are fetched are then casted to DTOs.
     * @return An ArrayList of ApplicationDTO objects, representing all rows of the application table
     */
    public List<ApplicationDTO> getAllApplications(){
        List<Application> appList = applicationRepository.findAll();
        List<ApplicationDTO> dtoList = new ArrayList<ApplicationDTO>();
        for(int i = 0; i < appList.size(); i++){
            dtoList.add((ApplicationDTO)appList.get(i));
        }
        return dtoList;
    }

}
