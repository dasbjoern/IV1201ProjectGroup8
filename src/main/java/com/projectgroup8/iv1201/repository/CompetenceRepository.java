package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectgroup8.iv1201.model.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    
    Competence findByName(String name);
}
