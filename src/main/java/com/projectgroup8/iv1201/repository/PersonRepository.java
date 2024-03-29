package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.projectgroup8.iv1201.model.Person;

/**
 * A repository for the person table in the database
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/repository/AccountRepository.java
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    public Person findByPersonId(long personId);
    public Person findByUsername(String username);
    public Person findByPnr(String personNumber);
    public Person findByEmail(String email);
    public List<Person> findAll();
    public List<Person> findByPersonIdInOrderByPersonIdAsc(List<Long> personIdList);
    // public List<Person> findAllByPerson_idOrderByPerson_idAsc(List<Long> personId);
}   
