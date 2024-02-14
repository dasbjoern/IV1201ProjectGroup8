package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Availability;

/**
 * A repository for the availability table in the database
 */
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long>{
    public Availability findByPersonId(long personId);
}
