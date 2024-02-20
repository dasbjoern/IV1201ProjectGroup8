package com.projectgroup8.iv1201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgroup8.iv1201.model.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    public Competence findById(long id);
    public Competence findByName(String name);
}
