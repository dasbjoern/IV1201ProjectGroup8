package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Person;
import com.projectgroup8.iv1201.model.PersonDTO;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    public PersonDTO findByPersonId(long personId);
    public Person findByUsername(String username);
    public PersonDTO findByPnr(String personNumber);
    public PersonDTO findByEmail(String email);
    
    // @Query("SELECT p FROM person p WHERE p.username = ?1 AND p.password = ?2")
    // public PersonDTO findPersonPassword(String username, String password);

}   
