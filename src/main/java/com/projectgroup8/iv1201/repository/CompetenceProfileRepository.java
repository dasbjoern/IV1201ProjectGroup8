package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.CompetenceProfile;

@Repository
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Long>{
    CompetenceProfile findByCompetenceId(Long competenceId);
    CompetenceProfile findByPersonId(Long personId);
}
