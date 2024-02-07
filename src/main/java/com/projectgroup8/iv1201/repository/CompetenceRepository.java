package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectgroup8.iv1201.model.Competence;

/**
 * A repository for hte competence table in the database
 */
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    
    public Competence findByName(String name);
}
