package com.projectgroup8.iv1201.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * Gets a person by username
     * @param username The username
     * @return A <code>Person</code> with the username. <ode>null</code> if no person was found
     */
    public PersonDTO getPerson(long id){
        return personRepository.findByPersonId(id);
    }
    
    public Competence getCompetence(String name){
        return competenceRepository.findByName(name);
    }
    public Person getPersonFromDTO(PersonDTO personDTO){
        Person person = new Person(personDTO);
        // person.setPassword(password);
        return person;
    }
    public long login(String username, String password){
        Person person = personRepository.findByUsername(username);
        return person.login(password);
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

}
