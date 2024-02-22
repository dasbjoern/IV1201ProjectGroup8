package com.projectgroup8.iv1201.service;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projectgroup8.iv1201.repository.*;
import com.projectgroup8.iv1201.model.*;
import java.util.Base64;

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
    public Competence getCompetence(String name){
        return competenceRepository.findByName(name);
    }

    /**
     * Fetches all competence profiles associated with a given person ID, then fetches all
     * competence tables associated with these profiles. Creates a combined DTO for each pair
     * of profile and competence.
     * @param personId The ID of the person for which the associated competence profiles are sought
     * @return A list of DTOs containing data from each profile and competence pair
     */
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

    /**
     * Fetches all availability entries associated with a given person ID, then converts to
     * a list of DTOs.
     * @param personId The ID of the person for which the associated availabilities are sought
     * @return A list of DTOs containing the data from an availability entry
     */
    public ArrayList<AvailabilityDTO> getAvailability(long personId){
        ArrayList<AvailabilityDTO> availabilityDTOList = new ArrayList<AvailabilityDTO>();
        List<Availability> availabilityList = availabilityRepository.findAllByPersonId(personId);
        for(int i = 0; i < availabilityList.size(); i++){
            availabilityDTOList.add((AvailabilityDTO)availabilityList.get(i));
        }
        return availabilityDTOList;
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
            return person.login(hashPassword(password, person.getSalt()));
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

        String passwordSalt = generateSalt();
        personEntity.setSalt(passwordSalt);
        personEntity.setPassword(hashPassword(registerForm.getPassword(), passwordSalt));
        Role roleObj = roleRepository.findByName("applicant");
        personEntity.setRoleId(roleObj.getRoleId());
        
        Person registeredPerson = personRepository.save(personEntity);
        
        return (registeredPerson.getPersonId() > 0);
       
    }

    /**********************************************
     * TEMPORARY METHOD
     */
    // private void updatePasswords(){
    //     List<Person> personList = personRepository.findAll();

    //     for(Person person : personList){
    //         if(person.getPassword() != null){
    //             String salt = generateSalt();
    //             person.setSalt(salt);
    //             person.setPassword(hashPassword(person.getPassword(), salt));
    //             personRepository.save(person);
    //         }
    //     }
    // }

    /**
     * Generates and returns a salt for a password
     * @return The salt
     */
    private String generateSalt(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Returns a SHA512 hashed password.
     * The implementation follows this guilde: https://www.baeldung.com/java-password-hashing
     * @param password The password to be hashed
     * @param salt The salt
     * @return The hashed password
     */
    private String hashPassword(String password, String salt){
        
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt.getBytes());

            byte[] hashedPassword = messageDigest.digest(password.getBytes());
    
            return Base64.getEncoder().encodeToString(hashedPassword);
        }
        /**
         * TODO: HANDLE THIS IN SOME WAY
         */
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Fetches all rows of the application table in the database. The Application
     * objects which are fetched are then casted to DTOs.
     * @return An ArrayList of ApplicationDTO objects, representing all rows of the application table
     */
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

    
    public List<ApplicationListDTO> getApplication(long personId){

        List<ApplicationListDTO> dtoList = new ArrayList<ApplicationListDTO>();
        Application application = applicationRepository.findByPersonId(personId);
        Person person = personRepository.findByPersonId(personId);
        dtoList.add(new ApplicationListDTO(application, person));

        return dtoList;
    }

}
