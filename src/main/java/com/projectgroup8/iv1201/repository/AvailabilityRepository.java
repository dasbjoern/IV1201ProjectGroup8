package com.projectgroup8.iv1201.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Availability;

/**
 * A repository for the availability table in the database
 * Inspired by: https://github.com/KTH-IV1201/bank/blob/master/src/main/java/se/kth/iv1201/appserv/bank/repository/AccountRepository.java
 */
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long>{
    public Availability findByPersonId(long personId);
    public List<Availability> findAllByPersonId(long personId);
}
