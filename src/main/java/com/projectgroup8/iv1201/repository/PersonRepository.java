package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findByPersonId(Long personId);
    Person findByUsername(String username);
    Person findByPnr(String personNumber);
    Person findByEmail(String email);
}
