package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long>{
    Availability findByPersonId(Long personId);
}
