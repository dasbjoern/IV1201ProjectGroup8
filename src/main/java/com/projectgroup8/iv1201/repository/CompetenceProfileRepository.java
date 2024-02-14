package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.CompetenceProfile;

/**
 * A repository for the competence profile table in the database
 */
@Repository
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Long>{
    public CompetenceProfile findByCompetenceId(long competenceId);
    public CompetenceProfile findByPersonId(long personId);
}
