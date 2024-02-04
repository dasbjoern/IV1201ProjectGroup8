package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    public Person findByPersonId(long personId);
    public Person findByUsername(String username);
    public Person findByPnr(String personNumber);
    public Person findByEmail(String email);
}
